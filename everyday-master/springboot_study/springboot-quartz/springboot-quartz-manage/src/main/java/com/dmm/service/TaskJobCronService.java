package com.dmm.service;

import com.dmm.entry.TaskJob;
import com.dmm.util.TaskUtil;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DMM
 * @create 2019/8/23
 */
@Service
public class TaskJobCronService {

    @Autowired
    private TaskJobService taskJobService;

    @Autowired
    private Scheduler scheduler;

    @Value("${job.execute.class-path}")
    private String jobExecuteClasspath;

    @Autowired
    private TaskUtil taskUtil;

    /**
     * 新增定时任务--cron
     * @param taskJob
     * @return
     */
    public boolean save(TaskJob taskJob) throws SchedulerException, ClassNotFoundException {

        taskJob.setCreateTime(System.currentTimeMillis());
        taskJob.setUpdateTime(System.currentTimeMillis());

        //1.增加记录
        long i=taskJobService.addTaskJob(taskJob);
        //2.获取jobKey
        JobKey jobKey=taskUtil.getCronJobKey(taskJob);

        //3.获取triggerKey
        TriggerKey triggerKey = taskUtil.genCronTriggerKey(taskJob);

        List<? extends Trigger> list=scheduler.getTriggersOfJob(jobKey);

        //判断是否存在重复的任务
        if(list.size()>0){
            return true;
        }

        if(taskJob.getStatus()==0){

            Class clazz=Class.forName(jobExecuteClasspath);

            JobDetail jobDetail=JobBuilder.newJob((Class<? extends Job>) clazz).withIdentity(jobKey).withDescription(taskJob.getJobDescription()).build();

            jobDetail.getJobDataMap().put("jobUrl",taskJob.getJobClassName());
            jobDetail.getJobDataMap().put("jobName",taskJob.getJobName());

            Trigger trigger=TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobKey).withSchedule(CronScheduleBuilder.cronSchedule(taskJob.getCron()).withMisfireHandlingInstructionDoNothing()).build();


            scheduler.scheduleJob(jobDetail,trigger);

        }

        scheduler.start();

        return true;
    }

    /**
     * 修改job--cron
     * 在对任务进行保存时需同步更新调度器中的定时任务配置
     * @param taskJob
     * @return
     */
    public boolean update(TaskJob taskJob) throws SchedulerException, ClassNotFoundException {

        TaskJob findTaskJob=taskJobService.getTaskJobOne(taskJob.getId());

        JobKey jobKey=taskUtil.getCronJobKey(taskJob);

        TriggerKey triggerKey=taskUtil.genCronTriggerKey(taskJob);

        // 如果不同则代表着CRON表达式已经修改，时间发生了变化
        if(!findTaskJob.getCron().equals(taskJob.getCron())){
            Trigger trigger=TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobKey).withSchedule(CronScheduleBuilder.cronSchedule(taskJob.getCron())).build();
            //刷新定时器
            scheduler.rescheduleJob(triggerKey,trigger);
        }

        //启动任务 0
        if(taskJob.getStatus()==0){
            Trigger trigger=scheduler.getTrigger(triggerKey);

            if(trigger==null){

                Class clazz=Class.forName(jobExecuteClasspath);

                // trigger如果为null则说明scheduler中并没有创建该任务
                JobDetail jobDetail=JobBuilder.newJob((Class<? extends Job>) clazz).withIdentity(jobKey).withDescription(taskJob.getJobDescription()).build();

                jobDetail.getJobDataMap().put("jobUrl",taskJob.getJobClassName());
                jobDetail.getJobDataMap().put("jobName",taskJob.getJobName());

                trigger=TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobKey).withSchedule(CronScheduleBuilder.cronSchedule(taskJob.getCron())).build();
                scheduler.scheduleJob(jobDetail,trigger);
            }else{
                // 不为null则说明scheduler中有创建该任务,更新即可
                TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobKey).withSchedule(CronScheduleBuilder.cronSchedule(taskJob.getCron())).build();
                scheduler.rescheduleJob(triggerKey,trigger);
            }

        }
        taskJob.setUpdateTime(System.currentTimeMillis());
        taskJobService.updateTaskJob(taskJob);
        return true;
    }

    /**
     * 获取Job信息
     *
     * @param taskJob
     * @return
     * @throws SchedulerException
     */
    public String getJobInfo(TaskJob taskJob) throws SchedulerException {
         //new TriggerKey(name, group);
        TriggerKey triggerKey =taskUtil.genCronTriggerKey(taskJob);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        return String.format("time:%s,state:%s", cronTrigger.getCronExpression(),
                scheduler.getTriggerState(triggerKey).name());
    }

    /**
     * 暂停所有任务
     * @throws SchedulerException
    */
    public boolean pauseAllJob() throws SchedulerException {
        scheduler.pauseAll();
        return true;
    }

    /**
     * 暂停某个任务
     * @param taskJob
     * @return
     * @throws SchedulerException
     */
    public boolean pauseJob(TaskJob taskJob) throws SchedulerException {
        JobKey jobKey=taskUtil.getCronJobKey(taskJob);
        JobDetail jobDetail=scheduler.getJobDetail(jobKey);
        if (jobDetail==null){
            return true;
        } else {
            scheduler.pauseJob(jobKey);
            return true;
        }
    }

    /**
     * 恢复所有任务
     * @throws SchedulerException
     */
    public boolean resumeAllJob()throws SchedulerException {
        scheduler.resumeAll();
        return true;
    }

    /**
     * 恢复某个任务
     * @param taskJob
     * @throws SchedulerException
     */
    public boolean resumeJob(TaskJob taskJob)throws SchedulerException{

        JobKey jobKey=taskUtil.getCronJobKey(taskJob);
        JobDetail jobDetail=scheduler.getJobDetail(jobKey);
        if (jobDetail==null)
            return true;
        scheduler.resumeJob(jobKey);
        return true;
    }

    public boolean deleteJob(TaskJob taskJob)throws SchedulerException{

        JobKey jobKey=taskUtil.getCronJobKey(taskJob);
        JobDetail jobDetail=scheduler.getJobDetail(jobKey);
        if (jobDetail==null)
            return true;
        scheduler.deleteJob(jobKey);
        return true;
    }


}

