package com.test.boot.dto;
/**
* @Description:    测试静态代码块(父类)
* @Author:         Joe
* @CreateDate:     2020/4/23 18:12
*/
public class Fathers {

    static {
        System.out.println("父类中的静态代码块");
    }

    Fathers(){
        System.out.println("父类中的构造函数");
    }

    {
        System.out.println("父类中的非静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("父类中的main方法");
    }
}
