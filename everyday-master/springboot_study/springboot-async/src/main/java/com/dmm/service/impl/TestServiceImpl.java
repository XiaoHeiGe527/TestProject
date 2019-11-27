package com.dmm.service.impl;

import com.dmm.service.TestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author DMM
 * @create 2019/10/12
 */
@Service
public class TestServiceImpl implements TestService {



    @Override
    @Async("testExecutor")
    public String a() throws InterruptedException {
        Thread.sleep(20);
        System.out.println("a-->"+System.currentTimeMillis());
        return null;
    }

    @Override
    @Async("testExecutor")
    public String b() {

        System.out.println("b-->"+System.currentTimeMillis());
        return null;
    }

    @Override
    @Async("testExecutor")
    public String c() {
        return null;
    }
}

