package com.dmm.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 *
 * 一个要求，要求序列化和反序列化一致
 * @author DMM
 * @create 2019/9/5
 */
@Component
public class RedisTool {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * setNx 操作
     * @param key
     * @param value
     * @return
     */
    public boolean setNx(String key,String value){
        return redisTemplate.opsForValue().setIfAbsent(key,value);
    }

    /**
     * 设置过期时间
     * @param key
     * @param time
     * @param timeUnit
     */
    public boolean setExpire(String key, long time, TimeUnit timeUnit){
        return redisTemplate.expire(key,time,timeUnit);
    }

    /**
     * getAndSet 设置现有的值，返回原来的值 如果不存在 则返回nil
     * @param key
     * @param value
     * @return
     */
    public String setGetAndSet(String key,String value){
        return (String) redisTemplate.opsForValue().getAndSet(key,value);
    }

    /**
     * 是否存在key
     * @param key
     * @return
     */
    public boolean exist(String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public boolean delKey(String key){
        return redisTemplate.delete(key);
    }

    /**
     *  获取value
     * @param key
     * @return
     */
    public String getKey(String key){

        System.out.println(redisTemplate.getDefaultSerializer().toString()+"序列化默认");
        System.out.println(redisTemplate.getKeySerializer().toString()+"序列化key");
        System.out.println(redisTemplate.getValueSerializer().toString()+"序列化value");
        System.out.println(redisTemplate.getStringSerializer().toString()+"序列化String");

        System.out.println(redisTemplate.opsForValue().get(key).toString());

        //默认采用的是jdk的序列化  如果对象是字符串，就使用String
        return redisTemplate.opsForValue().get(key).toString();
    }

    /**
     * 获取key集合
     * @param pattern
     * @return
     */
    public Set getKeys(String pattern){
        return redisTemplate.keys(pattern);
    }

    /**
     * 获取过期时间
     * @param key
     * @param timeUnit
     * @return
     */
    public long getExpire(String key,TimeUnit timeUnit){
        return redisTemplate.getExpire(key,timeUnit);
    }

    /**
     * 原子递增
     * @param key
     * @param num
     * @return
     */
    public long incr(String key,long num){
        //redisTemplate.setValueSerializer(new StringRedisSerializer());
        //redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        // 默认采用的是jdk,基本类型没有进行序列化
        // 但是返回时采用的反序列化，
        // 基本类型无法和对象及String进行转化，存储的则是string

        return redisTemplate.opsForValue().increment(key,num);
    }

    /**
     * 设置值
     * @param key
     * @param value
     */

    public void set(String key,Object value){
        //如果不设置value的序列化，存入的值将发生使用 JdkSerializationRedisSerializer()进行序列化
        //不管任何对象，记录的包括类的信息

        //设置
        //redisTemplate.setValueSerializer(new StringRedisSerializer());
        //redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.opsForValue().set(key,value);
    }
    public void getPattern(String key,String pattern,long count) throws IOException {
        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        // 设置value的序列化规则和 key的序列化规则
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        Cursor<Map.Entry<Object,Object>> cursor = redisTemplate.opsForHash().scan(key,
                ScanOptions.scanOptions().match(pattern).count(count).build()
        );
        try {

            while (cursor.hasNext()) {
//            Object key = cursor.next().getKey();
//            Set<Object> valueSet = cursor.next().getValue();
//                Object object = cursor.next();
                //Object object1=cursor.next().getKey();

                Object a = cursor.next().getKey().toString();
                Object valueSet = cursor.next().getValue();
                System.out.println("通过scan(K key, ScanOptions options)方法获取匹配的值:" + a);

                //System.out.println("通过scan(K key, ScanOptions options)方法获取匹配的值-----------------:" + object);
//            System.out.println(key+"___________________");

//            for (Object s:valueSet){
//                System.out.println(s);
//            }
            }
        }finally {
            cursor.close();
        }

        System.out.println("+++++++++++++++++++++++++++++");

    }

    /**
     * scan 实现
     * @param pattern    表达式
     * @param consumer    对迭代到的key进行操作
     */
    public void scan(String pattern, Consumer<byte[]> consumer) {
        this.redisTemplate.execute((RedisConnection connection) -> {
            try (Cursor<byte[]> cursor = connection.scan(ScanOptions.scanOptions().count(Long.MAX_VALUE).match(pattern).build())) {
                cursor.forEachRemaining(consumer);
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });
    }

    public void hset(String key,String ... value){
        redisTemplate.opsForSet().add(key,value);
    }


//    public Set<String> scan(String matchKey) {
//
//        Set<String> keys = redisTemplate.execute((RedisCallback<Set<String>>) connection -> {
//            Set<String> keysTmp = new HashSet<>();
//            Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match("*" + matchKey + "*").count(1000).build());
//            while (cursor.hasNext()) {
//                keysTmp.add(new String(cursor.next()));
//            }
//            return keysTmp;
//        });
//
//        return keys;
//    }

//    public Set<String> scan(String key) {
//        return redisTemplate.execute((RedisCallback<Set<String>>) connection -> {
//            Set<String> keys = Sets.newHashSet();
//
//            JedisCommands commands = (JedisCommands) connection.getNativeConnection();
//            MultiKeyCommands multiKeyCommands = (MultiKeyCommands) commands;
//
//            ScanParams scanParams = new ScanParams();
//            scanParams.match("*" + key + "*");
//            scanParams.count(1000);
//            ScanResult<String> scan = multiKeyCommands.scan("0", scanParams);
//            while (null != scan.getStringCursor()) {
//                keys.addAll(scan.getResult());
//                if (!StringUtils.equals("0", scan.getStringCursor())) {
//                    scan = multiKeyCommands.scan(scan.getStringCursor(), scanParams);
//                    continue;
//                } else {
//                    break;
//                }
//            }
//
//            return keys;
//        });
//    }



}

