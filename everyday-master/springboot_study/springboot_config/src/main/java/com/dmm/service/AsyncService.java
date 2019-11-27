package com.dmm.service;

import java.util.concurrent.Future;

/**
 * 异步调用
 * @author DMM
 * @create 2019/7/22
 */

public interface AsyncService {

    Future<String> doTask1() throws Exception;
    Future<String> doTask2() throws Exception;
    Future<String> doTask3() throws Exception;


}

