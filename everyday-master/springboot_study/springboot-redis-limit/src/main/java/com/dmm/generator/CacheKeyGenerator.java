package com.dmm.generator;

import org.aspectj.lang.ProceedingJoinPoint;

public interface CacheKeyGenerator {

    String getLockKey(ProceedingJoinPoint proceedingJoinPoint);
}
