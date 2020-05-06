package com.test.boot.dto;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.Locale;

@Data
public class Hello {
    private String name;
    private String address;
    private String job;
    private String music;


    public static void main(String[] args) {
        //设置 语言 ，地区
        Locale local = new Locale("zh","CN");
        //创建对象
        Faker faker = new Faker(local) ;
        for (int i = 0; i < 10; i++) {
            Hello hello = new Hello() ;
            hello.setName(faker.name().name());
            hello.setAddress(faker.address().fullAddress());
            hello.setJob(faker.job().seniority());
            hello.setMusic(faker.music().instrument());
            System.out.println(hello.toString());
        }
    }
}
