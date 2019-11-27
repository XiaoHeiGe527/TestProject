package com.dmm.controller;

import com.dmm.pojo.UserNode;
import com.dmm.pojo.UserRelation;
import com.dmm.service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DMM
 * @create 2019/10/9
 */
@RestController
public class UserRelationController {

    @Autowired
    private UserRelationService userRelationService;

    @PostMapping("/save/1")
    public List<UserRelation> addUser(){

        UserRelation userRelation=new UserRelation();
        UserNode start=new UserNode();
        UserNode end=new UserNode();
        start.setName("xmf");
        end.setName("hqf");
        userRelation.setStartNode(start);
        userRelation.setEndNode(end);

        return userRelationService.addUserNode(userRelation);

    }

    @PostMapping("/list/1")
    public List<UserRelation> addUserList(){

        UserRelation userRelation=new UserRelation();
        UserNode start=new UserNode();
        UserNode end=new UserNode();
        start.setName("dmm");
        end.setName("dmm2");
        userRelation.setStartNode(start);
        userRelation.setEndNode(end);

        return userRelationService.findUserNode(userRelation);

    }
}

