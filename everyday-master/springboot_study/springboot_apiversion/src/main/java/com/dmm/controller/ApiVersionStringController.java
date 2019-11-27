package com.dmm.controller;

import com.dmm.common.api.version.string.ApiVersionString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DMM
 * @create 2019/7/15
 */
@RestController
public class ApiVersionStringController {

    @RequestMapping("/string")
    @ApiVersionString
    public String string1(){
        return "AA";
    }
    @RequestMapping("/string")
    @ApiVersionString("0.0.0.1")
    public String string2(){
        return "BB";
    }
    @RequestMapping("/string")
    @ApiVersionString("0.0.0.2")
    public String string3(){
        return "CC";
    }
//    @RequestMapping("/string")
//    @ApiVersionString
//    public String string4(){
//        return "DD";
//    }
    @RequestMapping("/string5")
    public String string4(){
        return "CC";
    }



}

