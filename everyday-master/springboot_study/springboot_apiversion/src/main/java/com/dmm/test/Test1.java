package com.dmm.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author DMM
 * @create 2019/7/15
 */

public class Test1 {

    public static void main(String[] args) {

        //(([0-9]|([1-9]([0-9]*))).){3}([0-9]|([1-9]([0-9]*)))

        //(^[1-9]1[0-9]*)1(.)

        //((([1-9]([0-9]*))).){2}([0-9]|([1-9]([0-9]*)))

        //d+(.\d+){0,2}

       //  /^([1-9]\d|[1-9])(\.([1-9]\d|\d)){2}$/

        //正确的正则表达式

        Pattern pattern=Pattern.compile("^([1-9]\\d|\\d)(\\.([1-9]\\d|\\d)){3}$");



        String input="0.0.0.00";

        Matcher matcher=pattern.matcher(input);
        System.out.println(matcher.find());




    }
}

