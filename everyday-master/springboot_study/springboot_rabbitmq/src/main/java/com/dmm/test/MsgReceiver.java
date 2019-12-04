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

//    @RabbitListener(queues = {"first-queue"})
//    public void handleMessage(String messageStr, Message message, Channel channel) throws IOException {
//
//        System.out.println("======================first-queue=======================");
//        System.out.println(5/0);
//
//        System.out.println("first-queue 方法执行完毕！");
//
//    }

    @RabbitListener(queues = {"second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage2(String messageStr, Message message, Channel channel) throws Exception {
        // 处理消息
        System.out.println("SecondConsumer {} handleMessage :" + message);


        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

    }

}
