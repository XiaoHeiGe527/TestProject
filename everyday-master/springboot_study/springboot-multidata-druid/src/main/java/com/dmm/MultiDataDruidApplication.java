package com.dmm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DMM
 * @create 2019/8/2
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.dmm.mapper"})
public class MultiDataDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDataDruidApplication.class,args);
    }
}

