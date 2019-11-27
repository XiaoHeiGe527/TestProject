package com.dmm.controller;

import com.dmm.note.CacheLock;
import com.dmm.note.CacheParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DMM
 * @create 2019/9/6
 */
@RestController
public class LockController {

    @GetMapping("/test")
    @CacheLock(prefix = "dmm")
    public String query(@CacheParam(name = "token")@RequestParam String token){
        return "success---"+token;
    }
}

