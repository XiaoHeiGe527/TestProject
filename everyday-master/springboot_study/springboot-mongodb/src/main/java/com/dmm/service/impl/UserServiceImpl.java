package com.dmm.service.impl;

import com.dmm.entry.User;
import com.dmm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/25 19:12
 * @motto The more learn, the more found his ignorance.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String addUser(User user) {

        mongoTemplate.save(user);
        return "成功";
    }

    @Override
    public List<User> getUserList() {
        return mongoTemplate.findAll(User.class);
    }
}

