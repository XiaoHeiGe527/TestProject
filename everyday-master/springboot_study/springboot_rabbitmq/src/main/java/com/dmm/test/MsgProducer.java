package com.dmm.test;

import com.dmm.config.ExchangeConfig;
import com.dmm.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Component
public class MsgProducer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @Autowired
//    private RabbitAdmin rabbitAdmin;

    /**
     * 发送消息
     *
     * @param uuid
     * @param message 消息
     */
    public void send(String uuid, Object message) {
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(ExchangeConfig.EXCHANGE, RabbitConfig.ROUTINGKEY2,
                message, correlationId);
    }



//    /**
//     * 发送消息
//     *
//     * @param uuid
//     * @param message 消息
//     */
//    public void sendAdmin(String uuid, Object message) {
//
//        DirectExchange directExchange = new DirectExchange(ExchangeConfig.EXCHANGE, true, false);
//        rabbitAdmin.declareExchange(directExchange);
//
//        Queue queue = new Queue("testQueue", true, false, false);
//        rabbitAdmin.declareQueue(queue);
//
//        Binding binding = BindingBuilder.bind(queue).to(directExchange).with("testKey");
//        rabbitAdmin.declareBinding(binding);
//
//        //消息唯一ID
//        CorrelationData correlationId = new CorrelationData(uuid);
//        rabbitTemplate.convertAndSend(ExchangeConfig.EXCHANGE, "testKey", message, correlationId);
//
//        String testQueue = (String) rabbitTemplate.receiveAndConvert("testQueue");
//        System.out.println(testQueue);
//
//    }


    public void firstSend( Object message) {

        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);
        System.out.println("生成消息成功，id:" + correlationId.getId());
        rabbitTemplate.convertAndSend(ExchangeConfig.EXCHANGE, RabbitConfig.ROUTINGKEY1, message,correlationId);
        System.out.println("消息发送到RabbitMQ服务器成功，id:" + correlationId.getId());


        //   return BindingBuilder.bind(queueConfig.firstQueue()).to(exchangeConfig.directExchange()).with(RabbitConfig.ROUTINGKEY1);
        //     amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_A,RabbitmqConfig.ROUTINGKEY_A,id);

    }

}
