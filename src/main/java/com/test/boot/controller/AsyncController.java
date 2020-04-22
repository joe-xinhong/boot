package com.test.boot.controller;

import com.test.boot.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
* @Description:    测试线程
* @Author:         Joe
* @CreateDate:     2020/4/21 18:42
*/
@Slf4j
@RestController
@RequestMapping(value = "/threading")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping(value="/task",method = RequestMethod.GET)
    public String doTask() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncService.doTask1();
        Future<String> task2 = asyncService.doTask2();
        Future<String> task3 = asyncService.doTask3();
        while (true){
            if (task1.isDone() && task2.isDone() && task3.isDone()){
                break;
            }
            //如果没有执行完，让该检查的线程休息一秒再去检查
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("全部耗时："+(end-start)+"毫秒");
        log.info("异步花费时间:{}",end-start);
        return "success";
    }
}
