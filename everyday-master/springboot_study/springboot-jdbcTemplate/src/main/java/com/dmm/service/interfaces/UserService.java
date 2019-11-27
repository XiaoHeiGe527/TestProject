package com.dmm.service.interfaces;

import com.dmm.entry.User;

import java.util.List;

/**
 * @author DMM
 * @create 2019/7/29
 */

public interface UserService {

    User getUser(long id);

    int setUser(User user);

    List<User> getList();

    String abc();

    //增加
    void addUser(User user);
    //分页查找
    List<User> getList(int page,int limit);

    void addUser(String name,String password);

    User findUser(String name);
}

