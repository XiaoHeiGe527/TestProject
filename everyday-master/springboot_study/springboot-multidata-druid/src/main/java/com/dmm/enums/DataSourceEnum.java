package com.dmm.enums;

/**
 * 用于存放数据源名称
 */
public enum DataSourceEnum {

    DB1("db1"),DB2("db2");
    private String value;

    DataSourceEnum(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
