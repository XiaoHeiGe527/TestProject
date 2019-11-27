package com.dmm.controller;

import com.dmm.pojo.UserNode;
import com.dmm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DMM
 * @create 2019/10/9
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public List<UserNode> addUser(@RequestBody UserNode userNode){
        return userService.addUserNode(userNode);
    }

    @PostMapping("/list")
    public List<UserNode> addUser(){
        return userService.getUserNode();
    }

}

