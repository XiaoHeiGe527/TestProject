package com.dmm.controller;

import com.dmm.db1.service.UserService1;
import com.dmm.db2.service.UserService2;
import com.dmm.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DMM
 * @create 2019/7/31
 */
@Controller
public class IndexController {

    @Autowired
    private UserService2 userService2;

    @Autowired
    private UserService1 userService1;

    @RequestMapping("/db1/{name}/{password}")
    @ResponseBody
    public String add1(@PathVariable String name,@PathVariable String password){

        userService1.addUser(name,password);

        return "1成功";
    }
    @RequestMapping("/db2/{name}/{password}")
    @ResponseBody
    public String add2(@PathVariable String name,@PathVariable String password){

        userService2.addUser(name,password);

        return "2成功";
    }

    @RequestMapping("/db3/{name}/{password}")
    @ResponseBody
    public String add3(@PathVariable String name,@PathVariable String password){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        userService1.add(user);

        return "3成功";
    }
    @RequestMapping("/db4/{name}/{password}")
    @ResponseBody
    public String add4(@PathVariable String name,@PathVariable String password){

        User user=new User();
        user.setName(name);
        user.setPassword(password);
        userService2.add(user);

        return "4成功";
    }
}

