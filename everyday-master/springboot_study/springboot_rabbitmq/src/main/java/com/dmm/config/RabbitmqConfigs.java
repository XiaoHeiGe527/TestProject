package com.dmm.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConfigs{

    @Autowired
    private CachingConnectionFactory connectionFactory;


//    @Resource
//    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {

        //ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调   即消息发送到exchange  ack
        //ReturnCallback接口用于实现消息发送到RabbitMQ 交换器，但无相应队列与交换器绑定时的回调  即消息发送不到任何一个队列中  ack

        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey)
                -> {
            String id=message.getMessageProperties().getCorrelationId();
            System.out.println("消息"+id+"应答码"+replyCode+"原有"+replyText+"交换机"+exchange+"路由"+routingKey);
        });
        rabbitTemplate.setConfirmCallback((correlationData,ack,cause)->{
            if(ack){
                System.out.println("成功");
            }
            else System.out.println("失败");
        });
        return rabbitTemplate;
    }

//    @Override
//    public void confirm(CorrelationData correlationData, boolean b, String s) {
//
//    }
}
