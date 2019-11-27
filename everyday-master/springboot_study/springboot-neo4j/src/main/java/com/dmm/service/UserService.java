package com.dmm.service;

import com.dmm.dao.UserRepository;
import com.dmm.pojo.UserNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DMM
 * @create 2019/10/9
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserNode> addUserNode(UserNode userNode){
        return userRepository.addUserNodeList(userNode.getName(),userNode.getAge());
    }

    public List<UserNode> getUserNode(){
        return userRepository.getUserNodeList();
    }
}

