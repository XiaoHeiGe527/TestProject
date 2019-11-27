package com.dmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DMM
 * @create 2019/7/31
 */
@SpringBootApplication(scanBasePackages = "com.dmm")
public class MultiDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDataApplication.class,args);
    }
}

