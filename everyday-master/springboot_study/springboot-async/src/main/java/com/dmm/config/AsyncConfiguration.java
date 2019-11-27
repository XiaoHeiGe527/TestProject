package com.dmm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 线程池的配置
 * @author DMM
 * @create 2019/10/12
 */

// 启用异步任务
@Configuration
@EnableAsync
public class AsyncConfiguration {

//    @Value("${}")
//    private int corePoolSize;
//
//    @Value("${}")
//    private int maxPoolSize;
//
//    @Value("${}")
//    private int queueCapacity;
//
//    @Value("${}")
//    private boolean waitForTasksToCompleteOnShutdown;
//
//    @Value("${}")
//    private int awaitTerminationSeconds;
//
//    @Value("${}")
//    private String threadNamePrefix;
//
//    @Value("${}")
//    private int keepAliveSeconds;


    // 声明一个线程池(并指定线程池的名字)
    @Bean("testExecutor")
    public Executor testExecutor(){

        ThreadPoolTaskExecutor threadPoolTaskExecutor=new ThreadPoolTaskExecutor();
        //核心线程数5：线程池创建时候初始化的线程数
        threadPoolTaskExecutor.setCorePoolSize(5);
        //最大线程数5：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        threadPoolTaskExecutor.setMaxPoolSize(5);
        //缓冲队列500：用来缓冲执行任务的队列
        threadPoolTaskExecutor.setQueueCapacity(500);
        //允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
        threadPoolTaskExecutor.setKeepAliveSeconds(60);
        //等待任务在关机时完成--表明等待所有线程执行完
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        // 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
        threadPoolTaskExecutor.setAwaitTerminationSeconds(60);
        //线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
        threadPoolTaskExecutor.setThreadNamePrefix("thread-test-");
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }

}

