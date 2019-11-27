package com.dmm.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author DMM
 * @create 2019/9/3
 */
@Component
@Slf4j
public class LockUtil {

    @Value("${expire.time}")
    private long expireTime;

    @Autowired
    private RedisTool redisTool;

    /**
     * 上锁 //错误的加锁
     * @param key
     * @param value 作用
     * 我们传的是requestId，很多童鞋可能不明白，有key作为锁不就够了吗，为什么还要用到value？原因就是我们在上面讲到可靠性时，
     * 分布式锁要满足第四个条件解铃还须系铃人，通过给value赋值为requestId，我们就知道这把锁是哪个请求加的了，
     * 在解锁的时候就可以有依据。requestId可以使用UUID.randomUUID().toString()方法生成
     * @return
     */
    public boolean lock(String key,String value){

        //相当于SETNX指令，setIfAbsent方法设置了返回true,没有设置返回false

        if(redisTool.setNx(key,value)){
            log.info("取锁");
            return redisTool.setExpire(key,expireTime,TimeUnit.SECONDS);
        }

        if(redisTool.getExpire(key,TimeUnit.SECONDS) < 0){
            log.info(redisTool.getExpire(key,TimeUnit.SECONDS)+"");
            //假设currentValue=A   接下来并发进来的两个线程的value都是B  其中一个线程拿到锁,除非从始至终所有都是在并发（实际上这中情况是不存在的），只要开始时有数据有先后顺序，则分布式锁就不会出现“多卖”的现象
            String currentValue =  redisTool.getKey(key);
            log.error("万岁——————————————————————————————");
            //如果锁过期  解决死锁
            if(!StringUtils.isEmpty(currentValue) ){
                String oldValue= redisTool.setGetAndSet(key,value);
                //获取上一个锁的时间，锁过期后，GETSET将原来的锁替换成新锁
                if(!StringUtils.isEmpty(oldValue) && currentValue.equals(oldValue)){
                    return true;
                }
            }
        }

        //拿到锁的就有执行权力，拿不到的只有重新再来，重新再来只得是让用户手动继续抢单
        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key,String value){
        try {
            String currentValue = redisTool.getKey(key);
            if(!StringUtils.isEmpty(currentValue) && currentValue.equals(value)){
                log.info("解锁");
                redisTool.delKey(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【redis分布式锁】解锁异常, {}", e);
        }
    }



}

