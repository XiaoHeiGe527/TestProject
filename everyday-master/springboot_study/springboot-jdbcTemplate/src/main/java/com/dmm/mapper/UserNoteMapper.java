package com.dmm.mapper;

import com.dmm.entry.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author DMM
 * @create 2019/7/30
 */

public interface UserNoteMapper {

    //mapper使用注解的整合myabtis
    @Select("select * from user where name=#{name}")
    User findUserByName(@Param("name") String name);

    @Insert("insert into user (name,password) values (#{name},#{password})")
    void addUser(@Param("name") String name,@Param("password") String password);
}

