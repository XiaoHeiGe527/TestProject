package com.dmm.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author DMM
 * @create 2019/8/22
 */
@Configuration
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent> {

//    @Autowired
//    private QuartzManager quartzManager;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        try {
//            quartzManager.startJob();
//            System.out.println("任务已经启动......");
//            //log.info("任务已经启动......");
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
    }
//    /**
//     * 初始注入scheduler
//     */
//    @Bean
//    public Scheduler scheduler() throws SchedulerException{
//        SchedulerFactory schedulerFactoryBean = new StdSchedulerFactory();
//        return schedulerFactoryBean.getScheduler();
//    }

//    @Override
//    public void onApplicationEvent(ApplicationEvent event) {
//
//    }
}

