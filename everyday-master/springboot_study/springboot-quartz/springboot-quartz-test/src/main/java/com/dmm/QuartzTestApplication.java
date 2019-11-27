package com.dmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DMM
 * @create 2019/8/22
 */
@SpringBootApplication(scanBasePackages = "com.dmm")
public class QuartzTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzTestApplication.class,args);
    }
}

