package com.dmm.utils;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaySend {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;


    public void paysend1(){
        rabbitmqTemplate.convertAndSend("pay","dmm");
    }
}
