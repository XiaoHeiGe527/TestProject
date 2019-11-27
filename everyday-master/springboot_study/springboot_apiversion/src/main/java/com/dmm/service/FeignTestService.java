package com.dmm.service;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * 定义请求接口，生产者的接口
 */

//@Headers("")
public interface FeignTestService {

    @RequestLine("GET /dmm/aa?name={name}")
    String getStringHello(@Param(value = "name") String name);
    //拿到请求参数，放到生产者请求参数中

    @RequestLine("POST /dmm/bb")
    @Headers({"Content-Type: application/json","Accept: application/json"})
    Map postStringHello(@RequestBody Map map);
    //封装post请求，放body中
}
