package com.dmm.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * 异步处理，开启线程
 * @author DMM
 * @create 2019/7/22
 */
@Service
public class AsyncServiceImpl implements AsyncService{

    private static Random random=new Random();

    @Async
    @Override
    public Future<String> doTask1() throws Exception {

        System.out.println("任务1开始");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("任务1结束使用时间："+(end-start)+"毫秒");

        return new AsyncResult<>("任务一结束");
    }

    @Async
    @Override
    public Future<String> doTask2() throws Exception {
        System.out.println("任务2开始");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("任务2结束使用时间："+(end-start)+"毫秒");

        return new AsyncResult<>("任务二结束");
    }
    @Async
    @Override
    public Future<String> doTask3() throws Exception {
        System.out.println("任务3开始");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("任务3结束使用时间："+(end-start)+"毫秒");

        return new AsyncResult<>("任务三结束");
    }
}

