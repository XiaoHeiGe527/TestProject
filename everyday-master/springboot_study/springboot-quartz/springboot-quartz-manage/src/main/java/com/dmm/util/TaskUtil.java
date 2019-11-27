package com.dmm.util;

import com.dmm.entry.TaskJob;
import org.quartz.JobKey;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * task的工具类
 * @author DMM
 * @create 2019/8/23
 */
@Component
public class TaskUtil {

    /**
     * 基于cron调度的Job的默认组名
     */

    @Value("${task.name.cron}")
    public String CRON_JOB_GROUP_NAME_DEFAULT;

    /**
     * 基于simple调度的Job的默认组名
     */
    @Value("${task.name.simp}")
    public String SIMP_JOB_GROUP_NAME_DEFAULT;

    /**
     * 产生JobKey --cron
     * @param taskJob
     * @return
     */
    public JobKey getCronJobKey(TaskJob taskJob){
        return new JobKey("Job_"+taskJob.getJobName().trim()+"["+taskJob.getId()+"]",CRON_JOB_GROUP_NAME_DEFAULT);
    }

    /**
     * 产生TriggerKey --cron
     * @param taskJob
     * @return
     */
    public TriggerKey genCronTriggerKey(TaskJob taskJob){
        return new TriggerKey("Trigger_"+taskJob.getJobName().trim()+"["+taskJob.getId()+"]",CRON_JOB_GROUP_NAME_DEFAULT);
    }

    /**
     * 产生JobKey --simp
     * @param taskJob
     * @return
     */
    public JobKey getSimpJobKey(TaskJob taskJob){
        return new JobKey("Job_"+taskJob.getJobName().trim()+"["+taskJob.getId()+"]",SIMP_JOB_GROUP_NAME_DEFAULT);
    }

    /**
     * 产生TriggerKey --simp
     * @param taskJob
     * @return
     */
    public TriggerKey genSimpTriggerKey(TaskJob taskJob){
        return new TriggerKey("Trigger_"+taskJob.getJobName().trim()+"["+taskJob.getId()+"]",SIMP_JOB_GROUP_NAME_DEFAULT);
    }

    public boolean isTriggerKeyEqual(TriggerKey triggerKey1, TriggerKey triggerKey2){
        return triggerKey1.getName().equals(triggerKey2.getName()) && ((triggerKey1.getGroup() == null && triggerKey2.getGroup() == null)
                || (triggerKey1.getGroup() != null && triggerKey1.getGroup().equals(triggerKey2.getGroup())));
    }
}

