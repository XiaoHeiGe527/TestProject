package com.dmm.common.api.version.string;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义版本号标记注解 String
 * @author: Dmm
 * @date: 2019/4/18 10:51
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface ApiVersionString {

    // 定义接口的版本号 默认
    String value() default "0.0.0.0";
}
