package com.dmm.service;

import com.dmm.entry.User;

import java.util.Map;

/**
 * @author DMM
 * @create 2019/9/3
 */

public interface UserService {

    String modifyUser(User user);

    String test();

    String test2(Map map);

    String test22();

    long test23();

    void test24();

    void test25();

    String testTransaction();

    boolean abc();

}

