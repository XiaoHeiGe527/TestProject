package com.dmm.test;

import com.dmm.utils.ExceptionUtil;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MsgReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues = {"first-queue"})
    public void handleMessage(String messageStr, Message message, Channel channel) throws IOException {



        try {
            long deliverTag = message.getMessageProperties().getDeliveryTag();
            System.out.println(
                    "消费端接收到消息:" + new String(message.getBody()));
            System.out.println("[deliverTag:" + deliverTag + "] " + message.getMessageProperties().getReceivedRoutingKey());

            System.out.println("=================="+messageStr+"====================");

            System.out.println(5/0);


            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
            //
            System.out.println(5/0);
            logger.error("====================消息消费发生异常==================="+e);

            //手动应答 开启才有效
            // basicNack 参数： basicNack 该消息的index， deliveryTag 是否批量.true:将一次性拒绝所有小于deliveryTag的消息。
            //被拒绝的是否重新入队列
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);

            //basicAck
            //deliveryTag:该消息的index
            //multiple：是否批量.true:将一次性ack所有小于deliveryTag的消息。
            //channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            //deliveryTag:该消息的index
            //requeue：被拒绝的是否重新入队列
            // channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            //channel.basicNack 与 channel.basicReject 的区别在于basicNack可以拒绝多条消息，而basicReject一次只能拒绝一条消息
        }










    }

    @RabbitListener(queues = {"second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage2(String messageStr, Message message, Channel channel) throws Exception {
        // 处理消息
        System.out.println("SecondConsumer {} handleMessage :" + message);


        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

    }

}
