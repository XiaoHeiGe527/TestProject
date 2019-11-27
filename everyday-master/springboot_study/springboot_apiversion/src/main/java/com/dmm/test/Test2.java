package com.dmm.test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author DMM
 * @create 2019/7/16
 */

public class Test2 {

    public static void main(String[] args) {
        //凌晨
        Date nowDate=new Date();//不传参数默认当前日期
        nowDate.setHours(0);
        nowDate.setMinutes(0);
        nowDate.setSeconds(0);
        long date=nowDate.getTime();
        System.out.println(date);
        Date now=new Date(date);//当前凌晨日期
        //第二天凌晨
        Date tail=new Date();
        tail.setHours(23);
        tail.setMinutes(59);
        tail.setSeconds(59);
        long tailDate=tail.getTime();
        System.out.println(tailDate);
        Date taildate=new Date(tailDate);//第二天凌晨日期

        //获取的是
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 0); //0 当天凌晨，1当天23:59:59
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        System.out.println(calendar.getTimeInMillis());

    }
}

