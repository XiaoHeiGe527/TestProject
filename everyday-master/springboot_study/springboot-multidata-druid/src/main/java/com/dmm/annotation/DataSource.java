package com.dmm.annotation;

import com.dmm.enums.DataSourceEnum;

import java.lang.annotation.*;

/**
 * 用于aop类中当作切入点来选择数据源
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    DataSourceEnum value() default DataSourceEnum.DB1;
}
