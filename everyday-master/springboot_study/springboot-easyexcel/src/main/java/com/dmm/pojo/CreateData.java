package com.dmm.pojo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Mr. Du
 * @explain 创建学生集合
 * @createTime 2019/11/7 17:07
 * @motto The more learn, the more found his ignorance.
 */

public class CreateData {

    public static List<Student> createStudentList1(){

        List<Student> list= Lists.newArrayList();

        for (int i=0;i<10;i++){

            Student student=new Student();
            student.setName("杜明明"+i);
            student.setAge(25+i);
            student.setBirthday("0805"+i);
            student.setClassNo("005"+i);
            list.add(student);
        }
        return list;
    }

    public static List<Student> createStudentList2(){

        List<Student> list= Lists.newArrayList();

        for (int i=0;i<10;i++){

            Student student=new Student();
            student.setName("刘均红"+i);
            student.setAge(21+i);
            student.setBirthday("1003"+i);
            student.setClassNo("001"+i);
            list.add(student);
        }
        return list;
    }
}

