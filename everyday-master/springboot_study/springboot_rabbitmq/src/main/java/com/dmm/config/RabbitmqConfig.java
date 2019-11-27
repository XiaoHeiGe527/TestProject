package com.dmm.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置發送的隊列名稱，隊列實體
 */
@Configuration
public class RabbitmqConfig {

    public static final String EXCHANGE_A = "my-mq-exchange_A";
    public static final String EXCHANGE_B = "my-mq-exchange_B";
    public static final String EXCHANGE_C = "my-mq-exchange_C";


    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_C = "QUEUE_C";

    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
    public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";

    //定义routingKey为dmm的消息队列，使用默认的交互机

    @Bean(name = "sendDmm")
    public Queue sendDmm(){
        return new Queue("dmm");
    }

    @Bean(name = "sendMmd")
    public Queue sendMmd(){
        return new Queue("mmd");
    }



    @Bean(name = "sendA")
    public Queue sendA(){
        return new Queue(QUEUE_A);
    }

    @Bean(name = "sendB")
    public Queue sendB(){
        return new Queue(QUEUE_B);
    }
    @Bean(name = "sendC")
    public Queue sendC(){
        return new Queue(QUEUE_C);
    }

    /**
     * 定义各种交互机
     * @return
     */
    @Bean
    public Exchange aExchange(){
        return new DirectExchange(EXCHANGE_A);
    }
    @Bean
    public Exchange bExchange(){
        return new DirectExchange(EXCHANGE_B);
    }
    @Bean
    public Exchange cExchange(){
        return new DirectExchange(EXCHANGE_C);
    }

    // 定义绑定规则 队列 交换机 规则 a a a
    @Bean
    public Binding bindingAAA(){
        return BindingBuilder.bind(sendA()).to(aExchange()).with(ROUTINGKEY_A).noargs();

        //BindingBuilder.bind(queueA()).to(defaultExchange()).with(RabbitConfig.ROUTINGKEY_A);
        //理解 綁定器 綁定 隊列A 到 轉換器A 上，而規則是 routingkey必須是routingkey-a才能綁定。
    }
    @Bean
    public Binding bindingBAA(){
        return BindingBuilder.bind(sendB()).to(aExchange()).with(ROUTINGKEY_A).noargs();

        //BindingBuilder.bind(queueA()).to(defaultExchange()).with(RabbitConfig.ROUTINGKEY_A);
        //理解 綁定器 綁定 隊列A 到 轉換器A 上，而規則是 routingkey必須是routingkey-a才能綁定。
    }
    @Bean
    public Binding bindingABA(){
        return BindingBuilder.bind(sendA()).to(bExchange()).with(ROUTINGKEY_A).noargs();

        //BindingBuilder.bind(queueA()).to(defaultExchange()).with(RabbitConfig.ROUTINGKEY_A);
        //理解 綁定器 綁定 隊列A 到 轉換器A 上，而規則是 routingkey必須是routingkey-a才能綁定。
    }
//    @Bean
//    public Binding bindingBCC(){
//        return BindingBuilder.bind(sendB()).to(cExchange()).with(ROUTINGKEY_C).noargs();
//
//        //BindingBuilder.bind(queueA()).to(defaultExchange()).with(RabbitConfig.ROUTINGKEY_A);
//        //理解 綁定器 綁定 隊列A 到 轉換器A 上，而規則是 routingkey必須是routingkey-a才能綁定。
//    }
//    @Bean
//    public Binding bindingACC(){
//        return BindingBuilder.bind(sendA()).to(cExchange()).with(ROUTINGKEY_C).noargs();
//
//        //BindingBuilder.bind(queueA()).to(defaultExchange()).with(RabbitConfig.ROUTINGKEY_A);
//        //理解 綁定器 綁定 隊列A 到 轉換器A 上，而規則是 routingkey必須是routingkey-a才能綁定。
//    }
    @Bean
    public Binding bindingCAB(){
        return BindingBuilder.bind(sendC()).to(aExchange()).with(ROUTINGKEY_B).noargs();

        //BindingBuilder.bind(queueA()).to(defaultExchange()).with(RabbitConfig.ROUTINGKEY_A);
        //理解 綁定器 綁定 隊列A 到 轉換器A 上，而規則是 routingkey必須是routingkey-a才能綁定。
    }




}
