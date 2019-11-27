package com.dmm.controller;

import com.dmm.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 *
 * 开启多线程 springboot
 * @author DMM
 * @create 2019/7/22
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("async")
    public String asyncTest() throws Exception {

        long start=System.currentTimeMillis();


        Future<String> task1=asyncService.doTask1();
        Future<String> task2=asyncService.doTask2();
        Future<String> task3=asyncService.doTask3();

        while (true){
            if (task1.isDone() && task2.isDone() && task3.isDone()){
                break;
            }
            Thread.sleep(1000);
        }
        long end=System.currentTimeMillis();

        return "执行完毕"+(end-start)+"毫秒";
    }
}

