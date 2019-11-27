package com.dmm.controller;

import com.dmm.entry.TaskJob;
import com.dmm.service.TaskInitService;
import com.dmm.service.TaskJobCronService;
import com.dmm.service.TaskJobService;
import com.dmm.service.TaskJobSimpService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 * 定时任务的处理层
 * @author DMM
 * @create 2019/8/22
 */
@RestController
public class TaskJobController {

//    public static final String JOB1="job1";
//    public static final String GROUP1="group1";

//    @Autowired
//    private QuartzManager quartzManager;

    @Autowired
    private TaskJobService taskJobService;

    @Autowired
    private TaskJobCronService taskJobCronService;

    @Autowired
    private TaskJobSimpService taskJobSimpService;

    @Autowired
    private TaskInitService taskInitService;

//    @PostMapping("/modify/time")
//    public String modifyTaskJob(@RequestBody TaskJob taskJob) throws SchedulerException {
//
//        quartzManager.modifyJob(JOB1,GROUP1,taskJob.getCron());
//
//        return "OK";
//    }
//
//    @PostMapping("/pause/all")
//    public String pauseAllTaskJob() throws SchedulerException {
//
//        quartzManager.pauseAllJob();
//
//        return "OK";
//    }
//    @PostMapping("/resume/all")
//    public String resumeAllTaskJob() throws SchedulerException {
//
//        quartzManager.resumeAllJob();
//
//        return "OK";
//    }

    @PostMapping("/test")
    public Object test() {

       return taskJobService.getList();
    }

    /**
     * 增加定时任务
     * @param taskJob
     * @return
     * @throws ClassNotFoundException
     * @throws SchedulerException
     */
    @PostMapping("/task/add")
    public boolean add(@RequestBody TaskJob taskJob) throws ClassNotFoundException, SchedulerException {

        if(taskJob.getType()==1){
            return taskJobCronService.save(taskJob);
        }else{
            return taskJobSimpService.save(taskJob);
        }

    }

    /**
     * 修改定时任务
     * @param taskJob
     * @return
     */
    @PostMapping("/task/update")
    public boolean update(@RequestBody TaskJob taskJob) throws ClassNotFoundException, SchedulerException {
        if(taskJob.getType()==1){
            return taskJobCronService.update(taskJob);
        }
        return false;
    }

    @PostMapping("/get/job")
    public String getJob(@RequestBody TaskJob taskJob) throws SchedulerException {

        if(taskJob.getType()==1){
            return taskJobCronService.getJobInfo(taskJob);
        }
        return null;
    }

    @PostMapping("/pause/all")
    public boolean pauseAll() throws  SchedulerException {
        return taskJobCronService.pauseAllJob();

    }
    @PostMapping("/pause/info")
    public boolean pauseInfo(@RequestBody TaskJob taskJob) throws SchedulerException {
        if(taskJob.getType()==1){
            return taskJobCronService.pauseJob(taskJob);
        }
        return false;
    }
    @PostMapping("/resume/all")
    public boolean resumeAllJob() throws SchedulerException {
        return taskJobCronService.resumeAllJob();
    }
    @PostMapping("/resume/info")
    public boolean resumeInfo(@RequestBody TaskJob taskJob) throws ClassNotFoundException, SchedulerException {
        if(taskJob.getType()==1){
            return taskJobCronService.resumeJob(taskJob);
        }
        return false;
    }
    @PostMapping("/del/job")
    public boolean deleteJob(@RequestBody TaskJob taskJob) throws SchedulerException {
        if(taskJob.getType()==1){
            return taskJobCronService.deleteJob(taskJob);
        }
        return false;
    }

    @PostMapping("/all")
    public Map getAll(){
        return taskInitService.getAllJob();
    }


}

