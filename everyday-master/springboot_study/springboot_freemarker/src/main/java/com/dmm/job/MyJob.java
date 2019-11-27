package com.dmm.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author DMM
 * @create 2019/7/29
 */
@Component//任务调度的实例
public class MyJob {

    @Scheduled(fixedRate = 1000)//任务调度的时间间隔
    public void job(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}

