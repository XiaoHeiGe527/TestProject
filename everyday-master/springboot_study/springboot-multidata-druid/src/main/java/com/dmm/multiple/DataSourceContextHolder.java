package com.dmm.multiple;

import lombok.extern.slf4j.Slf4j;

/**
 * 数据源的持有者
 * 用于设置，获取，清空 当前线程内的数据源变量
 * @author DMM
 * @create 2019/8/5
 */
@Slf4j
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder=new InheritableThreadLocal<>();

    /**
     *  设置数据源
     * @param db
     */
    public static void setDataSource(String db){

        log.info("+++++++++++{}+++++++++++2",db);

        contextHolder.set(db);
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static String getDataSource(){
        log.info("+++++++++++{}+++++++++++3","1000000000000");
        return contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clear(){
        log.info("+++++++++++{}+++++++++++4","1000000000000");
        contextHolder.remove();
    }

}

