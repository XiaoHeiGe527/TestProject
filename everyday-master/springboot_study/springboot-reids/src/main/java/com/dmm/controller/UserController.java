package com.dmm.controller;

import com.dmm.entry.User;
import com.dmm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author DMM
 * @create 2019/9/3
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public String modify(@RequestBody User user, HttpSession httpSession) {
        //Cookie cookie=new Cookie("ee","啊啊啊");
        //httpServletResponse.addCookie(cookie);
        //httpSession.setAttribute("dmm","最漂亮");
//        try {
//            throw new Exception("我是错误");
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("{}",e);
//        }

        return userService.modifyUser(user);

        //System.out.println(1/0);

        //return userService.test();
    }

    @PostMapping("/test2")
    public String modify(@RequestBody Map map) {
        //return userService.test2(map);
        return userService.test22();
    }

    @PostMapping("/test3")
    public long modify() {
        //return userService.test2(map);
        return userService.test23();
    }

    @PostMapping("/test4")
    public void modify4() {
        userService.test24();
    }

    @PostMapping("/test5")
    public void modify5() {
        userService.test25();
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/test6")
    public String m1(){
        return stringRedisTemplate.opsForValue().increment("dmm",100L).toString();
    }

    @PostMapping("/test7")
    public void m2(){
         stringRedisTemplate.opsForValue().set("dmm","10000");
    }

    @PostMapping("/test8")
    public String m3(){
        return stringRedisTemplate.opsForValue().get("dmm");
    }

    @PostMapping("/test/transaction")
    public String testTransaction(){
        return userService.testTransaction();
    }

}

