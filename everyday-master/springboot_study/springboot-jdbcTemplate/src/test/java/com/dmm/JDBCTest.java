//package com.dmm;
//
//import com.dmm.entry.User;
//import com.dmm.service.interfaces.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author DMM
// * @create 2019/7/29
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = JdbcApplication.class)
//public class JDBCTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void set(){
//        User user=new User();
//        user.setName("杜明明");
//        user.setAge(25);
//        user.setSex((byte)0);
//        user.setPassword("123456");
//
//        System.out.println(userService.setUser(user));
//    }
//    @Test
//    public void get(){
//        System.out.println(userService.getUser(1L).getName());
//    }
//
//    @Test
//    public void getList(){
//        System.out.println(userService.getList().get(0).getName());
//    }
//
//}
//
