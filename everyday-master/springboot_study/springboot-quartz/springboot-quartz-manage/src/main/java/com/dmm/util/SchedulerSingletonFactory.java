package com.dmm.util;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 生产scheduler到spring容器中
 * 调度器工厂类，应当在Spring中将该类配置为单例
 * @author DMM
 * @create 2019/8/26
 */
@Configuration
public class SchedulerSingletonFactory {

    private volatile Scheduler scheduler;

    @Bean
    public Scheduler getScheduler(){

        Scheduler s=scheduler;

        if (s==null){
            //同步锁
            synchronized (this){
                //赋值
                s=scheduler;

                if(s==null){
                    // 双重检查
                    SchedulerFactory schedulerFactory=new StdSchedulerFactory();
                    try {
                        s=schedulerFactory.getScheduler();
                    } catch (SchedulerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return s;
    }


}

