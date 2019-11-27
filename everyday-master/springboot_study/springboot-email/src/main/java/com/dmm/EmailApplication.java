package com.dmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DMM
 * @create 2019/9/23
 */
@SpringBootApplication(scanBasePackages = "com.dmm")
public class EmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class,args);
    }
}

