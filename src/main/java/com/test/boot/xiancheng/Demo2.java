package com.test.boot.xiancheng;
/**
* @Description:    Java创建多线程:2.实现Runnable接口，重写run()[实现Runnable接口相比第一种继承Thread类的方式，使用了面向接口，将任务与线程进行分离，有利于解耦]
* @Author:         Joe
* @CreateDate:     2020/5/6 15:13
*/
//实现Runnable接口只是完成了线程任务的编写
//若要启动线程，需要new Thread(Runnable target)，再有thread对象调用start()方法启动线程
//此处我们只是重写了Runnable接口的Run()方法，并未重写Thread类的run()，让我们看看Thread类run()的实现
//本质上也是调用了我们传进去的Runnale target对象的run()方法

public class Demo2 implements Runnable {

    //重写的是Runnable接口的run()
    @Override
    public void run() {
        System.out.println(getClass().getName()+" implements Runnable is running");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Demo2());
        Thread thread2 = new Thread(new Demo2());
        thread1.start();
        thread2.start();
    }
}
