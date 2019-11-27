package com.dmm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DMM
 * @create 2019/7/29
 */
@SpringBootApplication
@MapperScan("com.dmm.mapper")//添加mapper层扫描 以防万一就添加上
public class JdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class,args);
    }
}

