package com.dmm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DMM
 * @create 2019/8/22
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.dmm.mapper"})
@MapperScan("com.dmm.mapper")
public class QuartzManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzManageApplication.class,args);
    }
}

