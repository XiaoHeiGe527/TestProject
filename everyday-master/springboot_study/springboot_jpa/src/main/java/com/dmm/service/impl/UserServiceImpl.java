package com.dmm.service.impl;

import com.dmm.dao.UserDao;
import com.dmm.entry.User;
import com.dmm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DMM
 * @create 2019/9/18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }
}

