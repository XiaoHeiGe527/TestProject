package com.dmm.utils;

import com.dmm.config.RabbitmqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 消息的生產方
 */
@Component
public class RabbitmqUtils {

    @Autowired
    private AmqpTemplate amqpTemplate;

    //test
    public void sendId(Long id){
        amqpTemplate.convertAndSend("delVm",id);
    }



    public void sendDmm(long id){
        amqpTemplate.convertAndSend("dmm",id);
    }

    public void sendMmd(long id){
        amqpTemplate.convertAndSend("mmd",id);
    }

    // 規則 交換機 規則  a a
    public void sendAA(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_A,RabbitmqConfig.ROUTINGKEY_A,id);
    }

    public void sendAB(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_A,RabbitmqConfig.ROUTINGKEY_B,id);
    }
    public void sendAC(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_A,RabbitmqConfig.ROUTINGKEY_C,id);
    }
    public void sendBA(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_B,RabbitmqConfig.ROUTINGKEY_A,id);
    }
    public void sendBB(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_B,RabbitmqConfig.ROUTINGKEY_B,id);
    }
    public void sendBC(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_B,RabbitmqConfig.ROUTINGKEY_C,id);
    }
    public void sendCA(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_C,RabbitmqConfig.ROUTINGKEY_A,id);
    }
    public void sendCB(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_C,RabbitmqConfig.ROUTINGKEY_B,id);
    }
    public void sendCC(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_C,RabbitmqConfig.ROUTINGKEY_C,id);
    }


    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.MIN;

        System.out.println(time.plusHours(1));
        time.toString();

//获得系统的时间，单位为毫秒,转换为妙

        long totalMilliSeconds = System.currentTimeMillis();

        long totalSeconds = totalMilliSeconds / 1000;

        //求出现在的秒
        long currentSecond = totalSeconds % 60;

        //求出现在的分
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;

        //求出现在的小时
        long totalHour = totalMinutes / 60;
        long currentHour = totalHour % 24;

        //显示时间
        System.out.println("总毫秒为： " + totalMilliSeconds);

        System.out.println(totalSeconds);

        System.out.println(totalMinutes);

        System.out.println(currentMinute);

        System.out.println(totalHour);

        System.out.println(totalHour*60*60*1000);

        System.out.println(currentHour);

        //System.out.println(totalHour/24);

        long a=totalHour/24;//获取的是

        System.out.println(a*24*60*60*1000-8*60*60*1000);


        System.out.println(
                ((totalMilliSeconds)/86400000)*86400000-8*60*60*1000

        );

//        System.out.println(
//                ((totalMilliSeconds-)/1000/60/60))*60*60*1000
//        );

        System.out.println("===============");

        System.out.println(currentHour + ":" + currentMinute + ":" + currentSecond + " GMT");

        LocalDateTime localDateTime=LocalDateTime.now();

        System.out.println();



        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);//当天零点



        String td_st_str =today_start.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println(td_st_str);




//        Calendar cal = Calendar.getInstance();
//        int offset = cal.get(Calendar.ZONE_OFFSET);
//        cal.add(Calendar.MILLISECOND, -offset);
//        Long timeStampUTC = cal.getTimeInMillis();
//        Long timeStamp = System.currentTimeMillis();
//        Long timeZone = (timeStamp - timeStampUTC) / (1000 * 3600);
//        System.out.println(timeZone.intValue());
//        System.out.println(timeZone);

        //iNow - (iNow + 8 * 3600) % 86400;
        System.out.println(totalMilliSeconds-(totalMilliSeconds+8*3600)%86400);
    }

}
