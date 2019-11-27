package com.dmm.service;

import com.dmm.entry.TaskJob;
import com.dmm.entry.TaskJobExample;
import com.dmm.mapper.TaskJobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DMM
 * @create 2019/8/23
 */
@Service
public class TaskJobService {

    @Autowired
    private TaskJobMapper taskJobMapper;

    /**
     * 获取集合
     * @return
     */
    public List<TaskJob> getList(){

        TaskJobExample taskJobExample=new TaskJobExample();

        return taskJobMapper.selectByExample(taskJobExample);
    }

    /**
     * 增加数据
     * @param taskJob
     * @return
     */
    public long addTaskJob(TaskJob taskJob){

        return taskJobMapper.insertSelective(taskJob);
    }

    /**
     * 修改数据
     * @param taskJob
     * @return
     */
    public long updateTaskJob(TaskJob taskJob){

        TaskJobExample taskJobExample=new TaskJobExample();
        taskJobExample.createCriteria().andIdEqualTo(taskJob.getId());

        return taskJobMapper.updateByExampleSelective(taskJob,taskJobExample);
    }

    /**
     * 获取某一个定时任务信息
     * @param id
     * @return
     */
    public TaskJob getTaskJobOne(Long id){
        return taskJobMapper.selectByPrimaryKey(id);
    }


}

