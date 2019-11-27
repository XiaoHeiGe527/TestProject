package com.dmm.controller;

import com.dmm.entry.User;
import com.dmm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DMM
 * @create 2019/9/18
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void addUsr(@RequestBody User user){
        userService.addUser(user);
    }

}

