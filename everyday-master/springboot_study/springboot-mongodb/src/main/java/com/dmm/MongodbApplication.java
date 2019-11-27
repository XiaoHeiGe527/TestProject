package com.dmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/25 18:14
 * @motto The more learn, the more found his ignorance.
 */
@SpringBootApplication(scanBasePackages = {"com.dmm"})
public class MongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class,args);
    }

}

