package com.dmm.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DMM
 * @create 2019/8/28
 */
@Configuration
public class Test1 {


    @Bean
    public Queue queue(){
        return new Queue("del");
    }

}

