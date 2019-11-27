package com.dmm.controller;


import com.dmm.service.TaskJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

//import java.util.logging.Logger;

/**
 * @author DMM
 * @create 2019/7/9
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    //log4j 日志配置
    //private Logger logger= Logger.getLogger(this.getClass());

    //logback 日志配置
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TaskJob taskJob;


    @RequestMapping("/hello")
    public String hello(){

        logger.debug("debug日志");
        logger.info("debug111111111111111111日志");
        logger.warn("debug日志");
        logger.error("debug11111111日志");

        return "hello";
    }
    @RequestMapping("/d")
    public String DD() throws FileNotFoundException {

        taskJob.dd();


        return "万岁";
    }

    @RequestMapping("/dc")
    public String DDc() throws FileNotFoundException {

        taskJob.ddc("/data/a.txt","e://logs/");


        return "万岁";
    }


}

