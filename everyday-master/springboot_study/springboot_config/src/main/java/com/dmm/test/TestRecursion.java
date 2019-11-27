package com.dmm.test;

import java.util.List;

/**
 * 测试递归  递归测试成功
 * @author DMM
 * @create 2019/7/23
 */


public class TestRecursion {

    public static void main(String[] args) {


//        List<Object> list=new ArrayList<>();
//
//        List<Object> list1=new ArrayList<>();
//        List<Object> list2=new ArrayList<>();
//
//        List<Object> list11=new ArrayList<>();
//        List<Object> list12=new ArrayList<>();
//        List<Object> list22=new ArrayList<>();
//        List<Object> list21=new ArrayList<>();
//
//        list.add(list1);
//        list.add(list2);
//
//        list1.add(list11);
//        list1.add(list12);
//
//        list2.add(list21);
//        list2.add(list22);
//
//        list11.add(11);
//        list11.add(1);
//        list11.add(112);
//        list12.add(12);
//        list12.add(122);
//
//        list21.add("杜明明1");
//        list22.add("杜明明2");
//        list21.add("杜明明3");
//        list22.add("杜明明4");
//        list22.add("杜明明5");
//        list22.add("杜明明6");
//
//        List a=new ArrayList();
//        get(list,a);
//        a.forEach(s->
//                System.out.println(s));

    }

    public static void get(List list,List list2){

        list.forEach(l->{

            if(l instanceof List){
                get((List)l,list2);
            }else
                //只取最终不是list的数据
                list2.add(l);

            //1.一种情形
//            if(l instanceof List){
                //如果对象是数组，进行递归
//                get((List)l,list2);
//            }
            //不管对象是不是数组还是常量，都会往集合中添加
//            list2.add(l);
        });
    }

}

