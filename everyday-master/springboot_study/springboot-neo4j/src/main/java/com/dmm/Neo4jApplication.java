package com.dmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @author DMM
 * @create 2019/10/9
 */
@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "com.dmm.dao")
public class Neo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class,args);
    }
}

