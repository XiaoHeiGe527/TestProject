//package com.dmm.controller;
//
//import com.dmm.service.FeignTestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
///**
// * @author DMM
// * @create 2019/7/12
// */
//@RestController()
//public class FeignTestController {
//
//    @Autowired
//    private FeignTestService feignTestService;
//
//    /**
//     * 解决在获取feign响应时，直接将字符串返回时，产生中文乱码问题
//     * 在RequestMapping加上produces = "application/json; charset=utf-8"
//     * @param name
//     * @return
//     */
//
//    @RequestMapping(value = "/test/aa",produces = "application/json; charset=utf-8")
//    public String get1(@RequestParam String name){
//        System.out.println(feignTestService.getStringHello(name));
//
//
//        return feignTestService.getStringHello(name);
//    }
//
//    @RequestMapping("/test/bb")
//    public Map get1(@RequestBody Map map){
//
//        System.out.println(map.get("name"));
//
//        return feignTestService.postStringHello(map);
//    }
//}
//
