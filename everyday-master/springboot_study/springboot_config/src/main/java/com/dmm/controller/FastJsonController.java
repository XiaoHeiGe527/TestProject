package com.dmm.controller;

import com.dmm.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *
 * springboot默认使用的jackJson的转换。
 * 修改FastJson
 * @author DMM
 * @create 2019/7/12
 */
@RestController
public class FastJsonController {

    @RequestMapping("/dmm")
    public User getUser(){
        User user=new User();
        System.out.println(1/0);
        user.setDate(new Date());
        user.setId(100);
        user.setName("杜明明");

        return user;
    }
}

