package com.dmm.db1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author DMM
 * @create 2019/7/31
 */
//@Qualifier("db1SqlSessionFactory")
public interface UserMapper1 {
    @Insert("insert into user (name,password) values (#{name},#{password})")
    void addUser(@Param("name")String name,@Param("password")String password);
}

