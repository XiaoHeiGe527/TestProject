package com.dmm.mapper;

import com.dmm.entry.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author DMM
 * @create 2019/8/13
 */
@Mapper
public interface StudentMapper {

    @Select("select * from t_student where name=#{name}")
    List<Student> getList(@Param("name") String name);

}

