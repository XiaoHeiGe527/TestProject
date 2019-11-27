package com.dmm.db2.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author DMM
 * @create 2019/7/31
 */
@Qualifier("db2SqlSessionFactory")
public interface UserMapper2 {
    @Insert("insert into user (name,password) values (#{name},#{password})")
    void addUser(@Param("name")String name, @Param("password")String password);
}

