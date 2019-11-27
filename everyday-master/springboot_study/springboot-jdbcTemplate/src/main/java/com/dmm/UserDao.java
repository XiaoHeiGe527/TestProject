package com.dmm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author DMM
 * @create 2019/7/29
 */
@Repository//dao层的包扫描，实体化
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(){
        jdbcTemplate.update("insert into user (name,password,age,sex) values (?,?,?,?)",new Object[]{"DMM","100",123,(byte)0});
    }
}

