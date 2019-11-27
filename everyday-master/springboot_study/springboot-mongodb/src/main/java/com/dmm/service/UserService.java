package com.dmm.service;

import com.dmm.entry.User;

import java.util.List;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/25 19:13
 * @motto If you would have leisure, do not waste it.
 */

public interface UserService {

    String addUser(User user);

    List<User> getUserList();
}
