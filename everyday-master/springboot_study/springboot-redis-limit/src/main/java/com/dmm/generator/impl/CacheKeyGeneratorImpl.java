package com.dmm.generator.impl;

import com.dmm.generator.CacheKeyGenerator;
import com.dmm.note.CacheLock;
import com.dmm.note.CacheParam;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author DMM
 * @create 2019/9/6
 */

public class CacheKeyGeneratorImpl implements CacheKeyGenerator {

    @Override
    public String getLockKey(ProceedingJoinPoint proceedingJoinPoint) {

        //获取签名
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();

        //获取方法
        Method method = signature.getMethod();
        //获取注解
        CacheLock lockAnnotation = method.getAnnotation(CacheLock.class);
        //获取参数的值
        final Object[] args = proceedingJoinPoint.getArgs();

        //获取参数类型
        final Parameter[] parameters = method.getParameters();

        StringBuilder builder = new StringBuilder();
        //默认解析方法里面带 CacheParam 注解的属性,如果没有尝试着解析实体对象中的
        for (int i = 0; i < parameters.length; i++) {
            //判断有无注解
            final CacheParam annotation = parameters[i].getAnnotation(CacheParam.class);
            if (annotation == null) {
                continue;
            }
            builder.append(lockAnnotation.delimiter()).append(args[i]);
        }
        if (StringUtils.isEmpty(builder.toString())) {
            final Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int i = 0; i < parameterAnnotations.length; i++) {
                final Object object = args[i];
                final Field[] fields = object.getClass().getDeclaredFields();
                for (Field field : fields) {
                    final CacheParam annotation = field.getAnnotation(CacheParam.class);
                    if (annotation == null) {
                        continue;
                    }
                    field.setAccessible(true);
                    builder.append(lockAnnotation.delimiter()).append(ReflectionUtils.getField(field, object));
                }
            }
        }
        return lockAnnotation.prefix() + builder.toString();
        //return null;
    }
}

