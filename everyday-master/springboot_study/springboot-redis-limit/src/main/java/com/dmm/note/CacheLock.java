package com.dmm.note;


import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 锁的注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheLock {

    /**
     * 锁的前缀
     * @return
     */
    String prefix() default "";

    /**
     * 过期时间
     * @return
     */
    int expire() default 10;

    /**
     * 超时时间单位 秒
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * <p>Key的分隔符（默认 :）</p>
     * <p>生成的Key：N:SO1008:500</p>
     * @return
     */
    String delimiter() default ":";
}
