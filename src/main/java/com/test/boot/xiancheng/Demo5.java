package com.test.boot.xiancheng;

import java.util.Timer;
import java.util.TimerTask;
/**
* @Description:    Java创建多线程:5.创建启动线程之Timer定时任务
* @Author:         Joe
* @CreateDate:     2020/5/6 15:35
*/
//Timer有不可控的缺点，当任务未执行完毕或我们每次想执行不同任务时候
public class Demo5 {
    public static void main(String[] args) {

        //行定时器任务使用的是schedule方法
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务延迟0(即立刻执行),每隔1000ms执行一次");
            }
        }, 0, 1000);
    }
}
