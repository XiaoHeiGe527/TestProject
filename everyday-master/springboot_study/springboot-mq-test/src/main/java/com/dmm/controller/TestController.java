package com.dmm.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author DMM
 * @create 2019/8/28
 */
@Controller
public class TestController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @PostMapping("/a")
    public String test(){

        amqpTemplate.convertAndSend("delVm",100);

        return "OK";
    }


}

