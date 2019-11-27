package com.dmm.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 全局异常的处理器
 * @author DMM
 * @create 2019/7/22
 */

//异常的注解 的通知
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public Map<String,Object> exception(Exception exception){

        Map<String,Object> map=new HashMap<>();
        map.put("code",600);
        map.put("errorMsg",exception.toString());

        return map;
    }
}

