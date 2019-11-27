package com.dmm.listener;

import com.dmm.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqListener {

    @RabbitListener(queues = "dmm")
    @RabbitHandler
    public void dmm(long id){
        System.out.println("接受-----"+id);
    }
    @RabbitListener(queues = "dmm")
    @RabbitHandler
    public void dmm2(long id){
        System.out.println("2接受-----"+id);
    }
    @RabbitListener(queues = "dmm")
    @RabbitHandler
    public void dmm3(long id){
        System.out.println("3接受-----"+id);
    }

    @RabbitListener(queues = RabbitmqConfig.QUEUE_A)
    @RabbitHandler
    public void a(long id){
        System.out.println("2346576789");System.out.println("接受-----AAAAAAAAAAAAAAA"+id);
    }
    @RabbitListener(queues = RabbitmqConfig.QUEUE_B)
    @RabbitHandler
    public void b(long id){
        System.out.println("2346576789srdfg");System.out.println("接受-----BBBBBBBBBBBBBBBBB"+id);
    }
    @RabbitListener(queues = RabbitmqConfig.QUEUE_C)
    @RabbitHandler
    public void c(long id){ System.out.println("接受-----cccccccccccccccccccccccccccc"+id); }
}
