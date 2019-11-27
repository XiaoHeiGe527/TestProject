package com.dmm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DMM
 * @create 2019/7/10
 */

//自定消息转换器的测试
@RestController
public class MessageController {

    //自定消息转换器的测试 实例话，springboot会自动配置，使用

    //Springboot默认配置了消息的转换器的,不需要我们配置
//    @Bean
//    public StringHttpMessageConverter stringHttpMessageConverters(){
//        StringHttpMessageConverter stringHttpMessageConverter=new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        return stringHttpMessageConverter;
//    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){

        return "啊啊啊啊";
    }
}

