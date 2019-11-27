package com.dmm.db1.service.impl;

import com.dmm.db1.mapper.User1Mapper;
import com.dmm.db1.mapper.UserMapper1;
import com.dmm.db1.service.UserService1;
import com.dmm.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author DMM
 * @create 2019/7/31
 */

@Service
public class UserServiceImpl1 implements UserService1 {

    @Autowired
    private UserMapper1 userMapper;

    @Autowired
    private User1Mapper user1Mapper;

    @Override
    @Transactional
    public void addUser(String name,String password) {

        userMapper.addUser(name,password);

    }

    @Override
    public void add(User user){
        user1Mapper.insertSelective(user);
    }
}

