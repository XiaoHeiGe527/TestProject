package com.dmm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DMM
 * @create 2019/8/22
 */
@RestController
public class JobController {


    @PostMapping("/dmm/job")
    public String print() throws InterruptedException {

        long startTime=System.currentTimeMillis();

        System.out.println("工作开始时间为："+startTime+"毫秒");

        Thread.sleep(1000);

        long beginTime=System.currentTimeMillis();

        System.out.println("工作结束时间为："+beginTime+"毫秒");

        return (beginTime-startTime)+"";
    }

}

