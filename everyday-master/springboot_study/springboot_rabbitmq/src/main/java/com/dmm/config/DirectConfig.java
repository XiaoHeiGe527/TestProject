package com.dmm.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 简单的生产消费
 */
@Configuration
public class DirectConfig {
    @Bean
    public Queue payQueue(){
        return new Queue("pay");
    }
}
