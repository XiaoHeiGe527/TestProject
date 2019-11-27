package com.dmm.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/7 16:51
 * @motto The more learn, the more found his ignorance.
 */

public class Student extends BaseRowModel {

    @ExcelProperty(value = "姓名",index = 0)
    private String name;
    @ExcelProperty(value = "年龄",index = 1)
    private int age;
    @ExcelProperty(value = "生日",index = 2)
    private String birthday;
    @ExcelProperty(value = "班级",index = 3)
    private String classNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }
}

