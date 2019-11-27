package com.dmm.dao;

import com.dmm.entry.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DMM
 * @create 2019/9/18
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
}

