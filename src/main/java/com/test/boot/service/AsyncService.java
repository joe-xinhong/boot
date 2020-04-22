package com.test.boot.service;

import java.util.concurrent.Future;

/**
* @Description:    线程任务
* @Author:         Joe
* @CreateDate:     2020/4/22 21:58
*/
public interface AsyncService {

    Future<String> doTask1()throws Exception;
    Future<String> doTask2()throws Exception;
    Future<String> doTask3()throws Exception;
}
