package com.dmm.util;

import com.dmm.entry.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @author DMM
 * @create 2019/9/4
 */
@Component
@Slf4j
public class LockUtil2 {

//    private static final String LOCK_SUCCESS = "OK";
//    private static final String SET_IF_NOT_EXIST = "NX";
//    private static final String SET_WITH_EXPIRE_TIME = "PX";

    private static final Long START_NUM = 10000L;

    private static final String VMKEY = "serial_vm_key";

    private static final long STARTNUM = 100000L;

    @Value("${expire.time}")
    private long expireTime;

    @Autowired
    private RedisTool redisTool;


    public long incrNum(String key,long value){
        long num=0L;
        boolean b=false;
        if(!redisTool.exist(key)){
            num=redisTool.incr(key,START_NUM);
            log.info("原子数-->{}",num);
            b=redisTool.setExpire(key,expireTime,TimeUnit.SECONDS);

            if(num>0L && b){
               return num;
            }
        }
        num=redisTool.incr(key,value);
        log.info("原子数-->{}",num);
        return num;
    }

    public long getVMSerialNum() {
        long  num = redisTool.incr(VMKEY, 1L);
        if(STARTNUM < num){
            return num;
        }else{
            return redisTool.incr(VMKEY, STARTNUM);
        }
    }

    public long get(){
        String s=redisTool.getKey(VMKEY);

        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        //return pattern.matcher(str).matches();
        if(pattern.matcher(s).matches()){
            return Long.parseLong(s);
        }
        System.out.println(s);
        log.info("存入的是",s);
        return 0L;
    }

    public void set(){
        redisTool.set(VMKEY,"10000");
    }

    public void set2(){

        User user=new User();
        user.setName("杜明明");
        user.setApikey("万佛朝宗");
        redisTool.set(VMKEY,user);
    }
}

