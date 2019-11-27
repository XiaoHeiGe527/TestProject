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
public class TaskJobSimpService {

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
        //1.增加记录
        long i=taskJobService.addTaskJob(taskJob);
        System.out.println(i);
        //2.获取jobKey
        JobKey jobKey=taskUtil.getSimpJobKey(taskJob);

        System.out.println(taskJob.getId()+"增加成功以后");
        //3.获取triggerKey
        TriggerKey triggerKey = taskUtil.genSimpTriggerKey(taskJob);

        List<? extends Trigger> list=scheduler.getTriggersOfJob(jobKey);

        if(list.size()>0){
            return true;
        }
        if(taskJob.getStatus()==0){

            Class clazz=Class.forName(jobExecuteClasspath);

            JobDetail jobDetail=JobBuilder.newJob((Class<? extends Job>) clazz).withIdentity(jobKey).withDescription(taskJob.getJobDescription()).build();

            jobDetail.getJobDataMap().put("jobUrl",taskJob.getJobClassName());
            jobDetail.getJobDataMap().put("jobName",taskJob.getJobName());

            Trigger trigger=TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobKey).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(taskJob.getIntervalTime())).build();

            scheduler.scheduleJob(jobDetail,trigger);

        }

        scheduler.start();

        return true;
    }

    /**
     * 获取Job信息
     *
     * @param name
     * @param group
     * @return
     * @throws SchedulerException
     */
    public String getJobInfo(String name, String group) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(name, group);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        return String.format("time:%s,state:%s", cronTrigger.getCronExpression(),
                scheduler.getTriggerState(triggerKey).name());
    }




}

