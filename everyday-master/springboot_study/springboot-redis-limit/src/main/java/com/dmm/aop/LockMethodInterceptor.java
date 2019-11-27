package com.dmm.aop;

import com.dmm.generator.CacheKeyGenerator;
import com.dmm.note.CacheLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 *
 * 切面的操作
 * @author DMM
 * @create 2019/9/6
 */
@Aspect
@Configuration
public class LockMethodInterceptor {

    private final StringRedisTemplate stringRedisTemplate;

    private final CacheKeyGenerator cacheKeyGenerator;

    /**
     * 实例化构造方法
     * @param stringRedisTemplate
     * @param cacheKeyGenerator
     */
    @Autowired
    public LockMethodInterceptor(StringRedisTemplate stringRedisTemplate, CacheKeyGenerator cacheKeyGenerator){
        this.stringRedisTemplate=stringRedisTemplate;
        this.cacheKeyGenerator=cacheKeyGenerator;
    }

    /**
     * 切面环绕
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(public * *(..)) && @annotation(com.dmm.note.CacheLock)")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint) {

        MethodSignature methodSignature=(MethodSignature) proceedingJoinPoint.getSignature();
        Method method=methodSignature.getMethod();
        CacheLock cacheLock=method.getAnnotation(CacheLock.class);

        if(StringUtils.isEmpty(cacheLock.prefix())){
            throw new RuntimeException("lock key can't be null...");
        }

        final String lockKey=cacheKeyGenerator.getLockKey(proceedingJoinPoint);
        String uuid= UUID.randomUUID().toString();
        try {

            final Boolean success=stringRedisTemplate.opsForValue().setIfAbsent(lockKey,uuid);

            if(success){
                stringRedisTemplate.expire(lockKey,cacheLock.expire(),cacheLock.timeUnit());
            }else {
                throw new RuntimeException("请勿重复请求");
            }

            try {
                return proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } finally {
            //如果演示的话需要注释该代码;实际应该放开
            //stringRedisTemplate.delete(lockKey);
        }
        return null;
    }
}

