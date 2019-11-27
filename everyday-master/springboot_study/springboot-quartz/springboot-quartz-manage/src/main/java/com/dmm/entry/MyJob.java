package com.dmm.entry;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 实现job接口
 * @author DMM
 * @create 2019/8/22
 */

public class MyJob implements Job {

    private void before(){
        System.out.println("任务开始执行");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //System.out.println("---------执行任务-----");
        before();
        System.out.println("开始："+System.currentTimeMillis());
        String jobUrl=jobExecutionContext.getJobDetail().getJobDataMap().getString("jobUrl");
        String jobName=jobExecutionContext.getJobDetail().getJobDataMap().getString("jobName");
        System.out.println(jobUrl);
        System.out.println(jobName);
        System.out.println("结束："+System.currentTimeMillis());
        after();

    }
    private void after(){
        System.out.println("任务开始执行");
    }

}

