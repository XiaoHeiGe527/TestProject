package com.dmm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author DMM
 * @create 2019/8/13
 */
@SpringBootApplication
@MapperScan(value = "com.dmm.mapper")
@EnableCaching//开启缓存
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class,args);
    }
}

