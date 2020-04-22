package com.test.boot.service.impl;

import com.test.boot.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    private static Random random = new Random();

    @Override
    @Async
    public Future<String> doTask1() throws Exception {
        System.out.println("任务1开始执行！");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("任务1结束！耗时："+(end-start)+"毫秒");
        return new AsyncResult<>("任务1结束");
    }

    @Override
    @Async
    public Future<String> doTask2() throws Exception {
        System.out.println("任务2开始执行！");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("任务2结束！耗时："+(end-start)+"毫秒");
        return new AsyncResult<>("任务2结束");
    }

    @Override
    @Async
    public Future<String> doTask3() throws Exception {
        System.out.println("任务3开始执行！");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("任务3结束！耗时："+(end-start)+"毫秒");
        return new AsyncResult<>("任务3结束");
    }
}
