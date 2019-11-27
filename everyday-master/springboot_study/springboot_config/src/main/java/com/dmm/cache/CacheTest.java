package com.dmm.cache;

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *
 * 缓存测试
 * @author DMM
 * @create 2019/8/13
 */

public class CacheTest {

    public static LoadingCache<String,String> loadingCache= CacheBuilder
            .newBuilder()
            .maximumSize(2)
            .refreshAfterWrite(2, TimeUnit.MILLISECONDS)
            .removalListener(new RemovalListener() {
                @Override
                public void onRemoval(RemovalNotification removalNotification){
                    System.out.println(removalNotification.getKey()+"被移除");
                }

            }).build(new CacheLoader() {
                @Override
                public Object load(Object key) throws Exception {

                    String strProValue = "hello " + (String) key + "!";

                    System.out.println("%%%%%" + strProValue);

                    return strProValue;
                }
            });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        loadingCache.get("jerry");
        loadingCache.get("peida");
        Thread.sleep(1000);
        loadingCache.get("jerry1");

        System.out.println(loadingCache.get("jerry1"));
    }



}

