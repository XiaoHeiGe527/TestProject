package com.dmm.controller;

import com.dmm.entry.Student;
import com.dmm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DMM
 * @create 2019/8/13
 */
@RestController
public class IndexController {

    //public static

    @Autowired
    private StudentService studentService;

    @PostMapping("/list/student")
    public List<Student> d(@RequestBody Student student){

        return studentService.getStudentList(student.getName());
    }
    @PostMapping("/remove/student")
    public String r(@RequestBody Student student){

        return studentService.remove(student.getName());
    }

}

