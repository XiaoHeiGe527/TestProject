package com.dmm.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DMM
 * @create 2019/8/13
 */
@Configuration
@EnableCaching
public class GuavaCacheConfig {

    @Bean
    public CacheManager cacheManager(){

//        GuavaCacheManager cacheManager = new GuavaCacheManager();
//        cacheManager.setCacheBuilder(
//                CacheBuilder.newBuilder().
//                        expireAfterWrite(10, TimeUnit.SECONDS).
//                        maximumSize(1000));


        SimpleCacheManager simpleCacheManager=new SimpleCacheManager();
//        ArrayList<> arrayList=new ArrayList();


        return simpleCacheManager;
    }


}

