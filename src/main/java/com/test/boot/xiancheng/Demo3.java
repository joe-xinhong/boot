package com.test.boot.xiancheng;
/**
* @Description:    Java创建多线程:3.匿名内部类[适用于创建启动线程次数较少的环境，书写更加简便]
* @Author:         Joe
* @CreateDate:     2020/5/6 15:21
*/
public class Demo3 {

    public static void main(String[] args) {
        //方式1：相当于继承了Thread类，作为子类重写run()实现
        new Thread(){
            @Override
            public void run() {
                System.out.println("匿名内部类创建线程方式1...");
            }
        }.start();

        //方式2:实现Runnable,Runnable作为匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类创建线程方式2...");
            }
        }).start();
    }
}
