package com.dmm.service.impl;

import com.dmm.entry.Student;
import com.dmm.mapper.StudentMapper;
import com.dmm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 查询数据的缓存
 * @author DMM
 * @create 2019/8/13
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Cacheable(cacheNames = "studentList",key = "#name")
    public List<Student> getStudentList(String name) {

        return studentMapper.getList(name);
    }

    @Override
    @CacheEvict(cacheNames = "studentList",key = "#name")
    public String remove(String name) {
        System.out.println("dddddddd");
        return "万岁";
    }




}

