package com.test.boot.xiancheng;
/**
* @Description:    Java创建多线程:1.继承Thread类，重写run()方法
* @Author:         Joe
* @CreateDate:     2020/5/6 15:04
*/
//Thread也是实现Runnable接口
public class Demo1 extends Thread {

    //重写的是父类Thread的run()
    @Override
    public void run() {
        System.out.println(getName()+" is running...");
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Demo1 demo2 = new Demo1();
        demo1.start();
        demo2.start();
    }
}
