package com.dmm.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    /**
     * 队列key1
     */
    public static final String ROUTINGKEY1 = "queue_one_key1";
    /**
     * 队列key2
     */
    public static final String ROUTINGKEY2 = "queue_one_key2";

    @Autowired
    private QueueConfig queueConfig;
    @Autowired
    private ExchangeConfig exchangeConfig;

    /**
     * 连接工厂
     */
//    @Autowired
//    private ConnectionFactory connectionFactory;

    /**
     * 将消息队列1和交换机进行绑定
     */
    @Bean
    public Binding binding_one() {
        return BindingBuilder.bind(queueConfig.firstQueue()).to(exchangeConfig.directExchange()).with(RabbitConfig.ROUTINGKEY1);
    }

    /**
     * 将消息队列2和交换机1进行绑定
     */
    @Bean
    public Binding binding_one_two() {
        return BindingBuilder.bind(queueConfig.firstQueue()).to(exchangeConfig.directExchange()).with(RabbitConfig.ROUTINGKEY2);
    }

    /**
     * 将消息队列2和交换机2进行绑定
     */
    @Bean
    public Binding binding_two() {
        return BindingBuilder.bind(queueConfig.secondQueue()).to(exchangeConfig.directExchange()).with(RabbitConfig.ROUTINGKEY2);
    }

    /**
     * 定义rabbit template用于数据的接收和发送
     *
     * @return
     */
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        return template;
//    }
//
//    /**
//     * 定义rabbitAdmin用于动态新建交换机和队列
//     *
//     * @return
//     */
//    @Bean
//    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        return new RabbitAdmin(connectionFactory);
//    }



}
