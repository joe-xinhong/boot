package com.test.boot.service;

import com.test.boot.entity.TbUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:    创建线程任务服务
* @Author:         Joe
* @CreateDate:     2020/4/21 18:53
*/
@Service
@Slf4j
public class ThreadingService {

    /**
     * @Description:通过@Async注解表明该方法是一个异步方法，
     * 如果注解在类级别上，则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
     * @Title: executeAsyncTask1
     * @Throws
     * @param i
     */
    @Async
    public void executeAsyncTask1(Integer i){
        log.info("ThreadingService ==> executeAsyncTask1 method: 执行异步任务{} ", i);
        List<TbUser> users = new ArrayList<>();
        for (int j = 0; j < 500; j++) {
            TbUser user = new TbUser();
            user.setId(j);
            users.add(user);
        }
        log.info("usersList:{}", users.size());
    }

    /**
     * @Description:通过@Async注解表明该方法是一个异步方法，
     * 如果注解在类级别上，则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
     * @Title: executeAsyncTask2
     * @Throws
     * @param i
     */
    @Async
    public void executeAsyncTask2(Integer i){
        log.info("ThreadingService ==> executeAsyncTask2 method: 执行异步任务{} ", i);
        List<TbUser> users = new ArrayList<>();
        for (int j = 0; j < 500; j++) {
            TbUser user = new TbUser();
            user.setId(j);
            users.add(user);
        }
        log.info("usersList:{}", users.size());
    }

    /**
     * @Description:通过@Async注解表明该方法是一个异步方法，
     * 如果注解在类级别上，则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
     * @Title: executeAsyncTask2
     * @Throws
     * @param i
     */
    public void executeAsyncTask3(Integer i){
        log.info("ThreadingService ==> executeAsyncTask3 method: 执行异步任务{} ", i);
        List<TbUser> users = new ArrayList<>();
        for (int j = 0; j < 1000; j++) {
            TbUser user = new TbUser();
            user.setId(j);
            users.add(user);
        }
        log.info("usersList:{}", users.size());
    }
}
