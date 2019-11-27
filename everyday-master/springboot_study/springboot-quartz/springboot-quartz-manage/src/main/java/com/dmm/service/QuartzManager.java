//package com.dmm.service;
//
//import com.dmm.entry.MyJob;
//import org.quartz.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Date;
//
///**
// * @author DMM
// * @create 2019/8/22
// */
//@Configuration
////@Service
//public class QuartzManager {
//
//    public static final String JOB1="job1";
//    public static final String GROUP1="group1";
//    /**默认每个星期凌晨一点执行*/
//    //public static final String DEFAULT_CRON="0 0 1 ? * L";
//    /**默认5秒执行一次*/
//    public static final String DEFAULT_CRON="*/5 * * * * ?";
//
//    @Autowired
//    private Scheduler scheduler;
//
//
//    /**
//     * 开始执行定时任务
//     */
//    public void startJob() throws SchedulerException {
//        startJobTask(scheduler);
//        scheduler.start();
//    }
//
//    /**
//     * 启动定时任务
//     * @param scheduler
//     */
//    private void startJobTask(Scheduler scheduler) throws SchedulerException {
//        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity(JOB1, GROUP1).build();
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(DEFAULT_CRON);
//        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(JOB1, GROUP1)
//                .withSchedule(cronScheduleBuilder).build();
//        scheduler.scheduleJob(jobDetail, cronTrigger);
//
//    }
//
//    /**
//     * 暂停所有任务
//     * @throws SchedulerException
//     */
//    public void pauseAllJob()throws SchedulerException{
//        scheduler.pauseAll();
//    }
//
//    /**
//     * 恢复所有任务
//     * @throws SchedulerException
//     */
//    public void resumeAllJob()throws SchedulerException{
//        scheduler.resumeAll();
//    }
//
//    /**
//     * 修改任务的执行时间
//     * @param name
//     * @param group
//     * @param cron cron表达式
//     * @return
//     * @throws SchedulerException
//     */
//    public boolean modifyJob(String name,String group,String cron) throws SchedulerException {
//        Date date = null;
//        TriggerKey triggerKey = new TriggerKey(name, group);
//        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
//        String oldTime = cronTrigger.getCronExpression();
//        if (!oldTime.equalsIgnoreCase(cron)) {
//            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
//            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group)
//                    .withSchedule(cronScheduleBuilder).build();
//            date = scheduler.rescheduleJob(triggerKey, trigger);
//        }
//        return date != null;
//    }
//
//
//}
//
