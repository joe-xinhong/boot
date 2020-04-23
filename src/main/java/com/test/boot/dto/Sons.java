package com.test.boot.dto;
/**
* @Description:    测试静态代码块(子类)
* @Author:         Joe
* @CreateDate:     2020/4/23 18:19
*/
public class Sons extends Fathers {

    static {
        System.out.println("子类中的静态代码块");
    }

    Sons(){
        System.out.println("子类中的构造函数");
    }

    {
        System.out.println("子类中的非静态代码块");
    }
    //1.静态代码块的特征，随着类的加载而执行，而且只执行一次
    //2.在子类中执行main方法，由于子类继承父类，所以父类中的静态代码块优先执行一次
    //3.静态代码块—>非静态代码块—>构造函数(执行顺序[先父后子])
    public static void main(String[] args) {
        System.out.println("子类中的main方法");
        new Sons();
    }
}
