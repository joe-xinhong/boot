package com.test.boot.controller;

import com.test.boot.service.ThreadingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    private ThreadingService threadingService;

    @RequestMapping(value="/task",method = RequestMethod.GET)
    public String doTask() {
        long start = System.currentTimeMillis();
        for (int i=0;i<2;i++){
            threadingService.executeAsyncTask1(i);
            threadingService.executeAsyncTask2(i);
        }
        float exc = (float)(System.currentTimeMillis() - start)/1000;
        log.info("异步花费时间:{}",exc);
        return "success";
    }

    @RequestMapping(value="/nottask",method = RequestMethod.GET)
    public String notTask(){
        long start = System.currentTimeMillis();
            threadingService.executeAsyncTask3(1);
        float exc = (float)(System.currentTimeMillis() - start)/1000;
        log.info("非异步花费时间:{}",exc);
        return "success";
    }
}
