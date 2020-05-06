package com.test.boot.xiancheng;

import java.util.Arrays;
import java.util.List;

/**
* @Description:    Java创建多线程:7.Lambda表达式的实现[使用Lambda表达式并行计算]
* @Author:         Joe
* @CreateDate:     2020/5/6 15:55
*/
public class Demo7 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Demo7 demo = new Demo7();
        int result = demo.add(list);
        System.out.println("计算后的结果为"+result);
    }

    public int add(List<Integer> list) {
        //若Lambda是串行执行,则应顺序打印
        list.parallelStream().forEach(System.out :: println);
        //Lambda有stream和parallelSteam(并行)
        return list.parallelStream().mapToInt(i -> i).sum();
    }
}
