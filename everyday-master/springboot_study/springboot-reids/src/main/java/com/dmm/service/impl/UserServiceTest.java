package com.dmm.service.impl;

import com.dmm.entry.User;
import com.dmm.entry.UserExample;
import com.dmm.mapper.UserMapper;
import com.dmm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DMM
 * @create 2019/9/18
 */
@Service
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Transactional
    public String test(){

        List<Long> longList=new ArrayList<>();


        longList.add(15L);
        longList.add(16L);

        UserExample userExample=new UserExample();
        userExample.createCriteria().andIdIn(longList);

        List<User> userList=userMapper.selectByExample(userExample);

        User user=new User();

        try {
            userList.forEach(l->{

                userExample.clear();

                userExample.createCriteria().andIdEqualTo(l.getId());

                user.setName("DMM"+l);

                userMapper.updateByExampleSelective(user,userExample);

                System.out.println(1/0);

            });

        } catch (Exception e) {

            log.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

            e.printStackTrace();

            return "一万";
        }


        return "一百万";
    }

    //@Transactional
    public boolean create(User user){

        int i=userMapper.insertSelective(user);

        //System.out.println(1/0);
        try {
            userService.abc();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-///////////////");
        }
//        try {
//            this.add();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("------------------");
//            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return false;
//        }

        return i==1;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean add(){
        System.out.println(1/0);
        return false;
    }


}

