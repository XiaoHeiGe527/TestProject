package com.dmm.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dmm.entity.Student;
import com.dmm.mapper.StudentMapper;
import com.dmm.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author DMM
 * @create 2019/8/7
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}

