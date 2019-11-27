package com.dmm.test;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author DMM
 * @create 2019/8/28
 */
@Component
public class MQListenTest {

    @RabbitHandler
    @RabbitListener(queues = "dmm")
    public void get(Message message){
        System.out.println(new Date());
        System.out.println(new String(message.toString()));
        System.out.println(new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = "del")
    public void get2(Message message){
        System.out.println(new Date());
        System.out.println(new String(message.toString()));
        System.out.println(new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = "delVm")
    public void get3(Message message){
        System.out.println(new Date());
        System.out.println(new String(message.toString()));
        System.out.println(new String(message.getBody()));
    }

    //@RabbitHandler
    @RabbitListener(queues = "delVm")
    public void get3(long message){
        System.out.println(new Date());
        //System.out.println(new String(message.toString()));
       //System.out.println(new String(message.getBody()));
        System.out.println(message);
    }
}

