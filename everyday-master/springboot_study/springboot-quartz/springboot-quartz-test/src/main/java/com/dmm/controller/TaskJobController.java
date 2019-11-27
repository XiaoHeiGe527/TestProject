package com.dmm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DMM
 * @create 2019/8/22
 */
@RestController
public class TaskJobController {

    //增加定时任务
    @PostMapping("/dmm/task/job")
    public String addTaskJob(){


        return null;
    }

}

