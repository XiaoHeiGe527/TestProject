package com.dmm.aop;

import com.dmm.annotation.DataSource;
import com.dmm.multiple.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author DMM
 * @create 2019/8/5
 */
@Component
@Slf4j
@Aspect
@Order(-1)
/**
 * 切面类
 */
public class DataSourceAspect {

    @Pointcut("@annotation(com.dmm.annotation.DataSource) || @within(com.dmm.annotation.DataSource)")
    public void pointCut(){}


    @Before("pointCut() && @annotation(dataSource)")
    public void doBefore(DataSource dataSource){
        log.info("选择数据源---"+dataSource.value().getValue());
        DataSourceContextHolder.setDataSource(dataSource.value().getValue());
    }

    @After("pointCut()")
    public void doAfter(){
        DataSourceContextHolder.clear();
    }
}

