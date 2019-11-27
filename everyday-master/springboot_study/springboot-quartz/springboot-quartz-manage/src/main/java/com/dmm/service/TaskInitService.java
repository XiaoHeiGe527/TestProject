package com.dmm.service;

import com.dmm.entry.TaskJob;
import com.dmm.util.TaskUtil;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.quartz.CronExpression.isValidExpression;

/**
 * @author DMM
 * @create 2019/8/28
 */
@Component
public class TaskInitService {

    @Autowired
    private TaskJobCronService taskJobCronService;

    @Autowired
    private TaskJobService taskJobService;

    @Autowired
    private Scheduler scheduler;

    @Value("${job.execute.class-path}")
    private String jobExecuteClasspath;

    @Autowired
    private TaskUtil taskUtil;

    @PostConstruct
    public void init(){
        if(scheduler==null){
            System.err.print("初始化定时任务组件失败，Scheduler is null...");
            return;
        }
        // 初始化基于cron时间配置的任务列表
        try {
            initCronJobs(scheduler);
        } catch (Exception e) {
            System.err.print("init cron tasks error,"+ e.getMessage());
        }
        try {
            System.err.print("The scheduler is starting...");

            scheduler.start(); // start the scheduler
        } catch (Exception e) {
            System.err.print("The scheduler start is error,"+ e.getMessage());
        }
    }

    /**
     * 初始化任务（基于cron触发器）
     *
     */
    private void initCronJobs(Scheduler scheduler) throws Exception {
        List<TaskJob> jobList = taskJobService.getList();
        if (jobList != null) {
            for (TaskJob taskJob : jobList) {
                scheduleCronJob(taskJob, scheduler);
            }
        }
    }
    /**
     * 安排任务(基于cron触发器)
     *
     * @param taskJob
     * @param scheduler
     */
    private void scheduleCronJob(TaskJob taskJob, Scheduler scheduler) {
        //&& StringUtils.isNotBlank(job.getJobname()) && StringUtils.isNotBlank(job.getJobclassname())
        //                && StringUtils.isNotBlank(job.getCron()) && scheduler != null
        if (taskJob != null )
        {
            if (taskJob.getStatus()==1) {
                return;
            }

            try {
                JobKey jobKey = taskUtil.getCronJobKey(taskJob);

                if (!scheduler.checkExists(jobKey)) {
                    // This job doesn't exist, then add it to scheduler.
                    System.err.print("Add new cron job to scheduler, jobName = " + taskJob.getJobName());
                    this.newJobAndNewCronTrigger(taskJob, scheduler, jobKey);
                } else {
                    System.err.print("Update cron job to scheduler, jobName = " + taskJob.getJobName());
                    this.updateCronTriggerOfJob(taskJob, scheduler, jobKey);
                }
            } catch (Exception e) {
                System.err.print("ScheduleCronJob is error," + taskJob.getJobName());
            }
        } else {
            System.err.print("Method scheduleCronJob arguments are invalid.");
        }
    }
    /**
     * 新建job和trigger到scheduler(基于cron触发器)
     *
     * @param taskJob
     * @param scheduler
     * @param jobKey
     * @throws SchedulerException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void newJobAndNewCronTrigger(TaskJob taskJob, Scheduler scheduler, JobKey jobKey)
            throws SchedulerException, ClassNotFoundException {
        TriggerKey triggerKey = taskUtil.genCronTriggerKey(taskJob);

        String cronExpr = taskJob.getCron();
        if (!isValidExpression(cronExpr)) {
            return;
        }

        // get a Class object by string class name of job;
        //Class jobClass = Class.forName(job.getJobclassname().trim());
        //Class jobClass = CglibUtil.getClass(job.getJobname());
        Class jobClass = Class.forName(jobExecuteClasspath);
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobKey).withDescription(taskJob.getJobDescription())
                .build();
        jobDetail.getJobDataMap().put("jobUrl",taskJob.getJobClassName());//传参
        jobDetail.getJobDataMap().put("jobName",taskJob.getJobName());
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobKey)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpr).withMisfireHandlingInstructionDoNothing())
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 更新job的trigger(基于cron触发器)
     *
     * @param taskJob
     * @param scheduler
     * @param jobKey
     * @throws SchedulerException
     */
    private void updateCronTriggerOfJob(TaskJob taskJob, Scheduler scheduler, JobKey jobKey) throws SchedulerException {
        TriggerKey triggerKey = taskUtil.genCronTriggerKey(taskJob);
        String cronExpr = taskJob.getCron().trim();

        List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);

        for (int i = 0; triggers != null && i < triggers.size(); i++) {
            Trigger trigger = triggers.get(i);
            TriggerKey curTriggerKey = trigger.getKey();

            if (taskUtil.isTriggerKeyEqual(triggerKey, curTriggerKey)) {
                if (trigger instanceof CronTrigger
                        && cronExpr.equalsIgnoreCase(((CronTrigger) trigger).getCronExpression())) {
                    // Don't need to do anything.
                } else {
                    if (isValidExpression(taskJob.getCron())) {
                        // Cron expression is valid, build a new trigger and
                        // replace the old one.
                        CronTrigger newTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobKey)
                                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpr)
                                        .withMisfireHandlingInstructionDoNothing())
                                .build();
                        scheduler.rescheduleJob(curTriggerKey, newTrigger);
                    }
                }
            } else {
                // different trigger key ,The trigger key is illegal, unschedule
                // this trigger
                scheduler.unscheduleJob(curTriggerKey);
            }

        }
    }






    public Map getAllJob(){


        Map result = new HashMap();
        try {
            List list = new ArrayList();
            //Scheduler scheduler = schedulerFactory.getScheduler();
            for (String groupName : scheduler.getJobGroupNames()) {
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                    Map map = new HashMap();
                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();
                    //get job's trigger
                    List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                    Date nextFireTime = triggers.get(0).getNextFireTime();
//                    System.out.println("[jobName] : " + jobName + " [groupName] : "
//                            + jobGroup + " - " + nextFireTime);
                    map.put("jobName",jobName);
                    map.put("groupName",jobGroup);
                    map.put("nextFireTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nextFireTime));
                    list.add(map);
                }
            }
            result.put("joblist",list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

