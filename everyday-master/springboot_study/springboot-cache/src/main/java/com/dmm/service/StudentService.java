package com.dmm.service;

import com.dmm.entry.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList(String name);

    String remove(String name);
}
