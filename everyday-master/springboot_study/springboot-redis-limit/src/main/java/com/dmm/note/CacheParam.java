package com.dmm.note;

import java.lang.annotation.*;

/**
 * 锁的参数
 * @author DMM
 * @create 2019/9/6
 */
@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheParam {

    /**
     * 字段名字
     * @return
     */
    String name() default "";

}

