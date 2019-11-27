//package com.dmm.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.session.data.redis.RedisFlushMode;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
///**
// * SessionConfig httpSession的默认配置
// * @author DMM
// * @create 2019/9/3
// */
///**
// * maxInactiveIntervalInSeconds 最大无效间隔秒
// *
// * 设置Session失效时间，使用Redis Session之后 默认1800s
// * #session更新策略，有ON_SAVE、IMMEDIATE，前者是在调用#SessionRepository#save(org.springframework.session.Session)时，
// * 在response commit前刷新缓存，#后者是只要有任何更新就会刷新缓存
// *
// * cleanupCron() default "0 * * * * *";
// * 清空的cron表达式
// */
//
//@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60, redisFlushMode = RedisFlushMode.IMMEDIATE, redisNamespace = "session" )
//public class SessionConfig {
//}
//
