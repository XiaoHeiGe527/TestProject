package com.dmm.controller;

import com.dmm.entry.User;
import com.dmm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/25 19:21
 * @motto The more learn, the more found his ignorance.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/list")
    public List<User> addUser(){
        return userService.getUserList();
    }


}

