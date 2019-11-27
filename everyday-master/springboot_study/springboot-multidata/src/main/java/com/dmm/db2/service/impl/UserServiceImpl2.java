package com.dmm.db2.service.impl;

import com.dmm.db2.mapper.User2Mapper;
import com.dmm.db2.mapper.UserMapper2;
import com.dmm.db2.service.UserService2;
import com.dmm.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author DMM
 * @create 2019/7/31
 */

@Service
public class UserServiceImpl2 implements UserService2 {

    @Autowired
    private UserMapper2 userMapper;

    @Autowired
    private User2Mapper user2Mapper;

    // 注：不是主数据源必须要声明其数据源，否则事务不起作用
    @Override
    @Transactional(value = "db2DataSourceTransactionManager")
    public void addUser(String name,String password) {

        userMapper.addUser(name,password);
        System.out.println(1/0);

    }

    @Override
    @Transactional(value = "db2DataSourceTransactionManager")
    public void add(User user){
        user2Mapper.insertSelective(user);
        System.out.println(1/0);
    }
}

