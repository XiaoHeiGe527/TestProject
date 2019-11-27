package com.dmm.entry;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class TTempTest extends BaseRowModel {

    @ExcelProperty(value = "ID",index = 0)
    private Integer id;
    @ExcelProperty(value = "name",index = 1)
    private String name;
    @ExcelProperty(value = "name1",index = 2)
    private String name1;
    @ExcelProperty(value = "name2",index = 3)
    private String name2;
    @ExcelProperty(value = "name3",index = 4)
    private String name3;
    @ExcelProperty(value = "name4",index = 5)
    private String name4;
    @ExcelProperty(value = "name5",index = 6)
    private String name5;
    @ExcelProperty(value = "name6",index = 7)
    private String name6;
    @ExcelProperty(value = "name7",index = 8)
    private String name7;
    @ExcelProperty(value = "name8",index = 9)
    private String name8;
    @ExcelProperty(value = "name9",index = 10)
    private String name9;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1 == null ? null : name1.trim();
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2 == null ? null : name2.trim();
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3 == null ? null : name3.trim();
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4 == null ? null : name4.trim();
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5 == null ? null : name5.trim();
    }

    public String getName6() {
        return name6;
    }

    public void setName6(String name6) {
        this.name6 = name6 == null ? null : name6.trim();
    }

    public String getName7() {
        return name7;
    }

    public void setName7(String name7) {
        this.name7 = name7 == null ? null : name7.trim();
    }

    public String getName8() {
        return name8;
    }

    public void setName8(String name8) {
        this.name8 = name8 == null ? null : name8.trim();
    }

    public String getName9() {
        return name9;
    }

    public void setName9(String name9) {
        this.name9 = name9 == null ? null : name9.trim();
    }
}