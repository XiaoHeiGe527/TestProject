package com.dmm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Mr. Du
 * @explain 启动类
 * @createTime 2019/11/7 16:42
 * @motto The more learn, the more found his ignorance.
 */
@SpringBootApplication
@MapperScan("com.dmm.mapper")
public class EasyExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyExcelApplication.class,args);
    }
}

