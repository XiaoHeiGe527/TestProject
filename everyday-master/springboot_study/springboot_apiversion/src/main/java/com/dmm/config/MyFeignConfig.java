package com.dmm.config;

import com.dmm.service.FeignTestService;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 初始化
 * @author DMM
 * @create 2019/7/12
 */

@Configuration
public class MyFeignConfig {

    @Value("${myfeign.ip}")
    private String feignTest;


    @Bean
    public FeignTestService requestFeignTest(){

        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
             //   .encoder()
                .options(new Request.Options(1000,3500))
                .retryer(new Retryer.Default(5000,5000,3))
                .target(FeignTestService.class,feignTest);
    }



}

