package com.dmm;

import com.dmm.generator.CacheKeyGenerator;
import com.dmm.generator.impl.CacheKeyGeneratorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author DMM
 * @create 2019/9/6
 */
@SpringBootApplication
public class SpringBootRedisLimit {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisLimit.class,args);
    }

    //注入CacheKeyGenerator的实体bean
    @Bean
    public CacheKeyGenerator cacheKeyGenerator(){
        return new CacheKeyGeneratorImpl();
    }
}

