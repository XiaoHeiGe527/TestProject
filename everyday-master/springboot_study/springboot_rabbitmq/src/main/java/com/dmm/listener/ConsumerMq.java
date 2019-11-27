package com.dmm.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component

public class ConsumerMq {

    @RabbitListener(queues = "hello")
    public void process(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        System.out.println(message.getBody().toString()+"===============");
    }

//    @RabbitHandler
//    public void s(int s){
//        System.out.println(s);
//    }

}
