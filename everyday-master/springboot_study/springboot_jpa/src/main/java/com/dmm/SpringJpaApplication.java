package com.dmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author DMM
 * @create 2019/9/18
 */
@SpringBootApplication(scanBasePackages = "com.dmm")
@EntityScan("com.dmm.entry")
public class SpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class,args);
    }
}

