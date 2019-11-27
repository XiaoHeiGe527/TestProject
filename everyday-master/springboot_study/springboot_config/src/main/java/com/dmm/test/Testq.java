package com.dmm.test;

/**
 * @author DMM
 * @create 2019/8/12
 */

public class Testq {

    public static void main(String[] args) {

//        double d=(double)5;
//        double c=(double)10;
//
//        int f=3;
//        double i=(d/c);
//        System.out.println(2.0/3.0);
//        System.out.println(i);
//        System.out.println((int)Math.floor(i*f));
//
//        System.out.println(Math.floorMod(170,160));

//        test1(1);
//        test2(-3);

    //断言1结果为true，则继续往下执行
        assert true;
        System.out.println("断言1没有问题，Go！");

        System.out.println("\n-----------------\n");

        //断言2结果为false,程序终止
        assert 1>2 : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
        System.out.println("断言2没有问题，Go！");

    }

    private static void test1(int a){
        assert a > 0;
        System.out.println(a);
    }
    private static void test2(int a){
        assert a > 0 : "something goes wrong here, a cannot be less than 0";
        System.out.println(a);
    }
}

