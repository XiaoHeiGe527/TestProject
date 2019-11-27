package com.dmm.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "pay")
public class PayListener {

    @RabbitHandler
    public void payHandler(String s){
        System.out.println(s+"杜明明");
    }


}
