package com.dmm.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 生产者。。服务
 * @author DMM
 * @create 2019/7/12
 */

@RestController
public class FeignTestC {

    @RequestMapping(value = "/aa",produces = "application/json; charset=utf-8")
    public String get1(@RequestParam String name){
        System.out.println(name);

        String s="{\"name\":\""+name+"\"}";

        return s;
    }

    @RequestMapping("/bb")
    public Map post1(@RequestBody Map map){
        System.out.println(map.get("name"));

        return map;
    }
}

