package com.dmm.controller;

import com.dmm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DMM
 * @create 2019/10/12
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/abc")
    public String abc() throws InterruptedException {

        for (int i=0;i<10;i++){
            testService.a();
            testService.b();
        }

        return "dmm";
    }

}

