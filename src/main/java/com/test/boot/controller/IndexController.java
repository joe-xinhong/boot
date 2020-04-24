package com.test.boot.controller;

import com.test.boot.db1.service.UserService;
import com.test.boot.db2.service.UsersService;
import com.test.boot.entity.TbUser;
import com.test.boot.entity.TbUsers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/user",name = "用户管理")
public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/addUser",method = RequestMethod.GET,name = "新增用户")
    public String addUser(){
        TbUser user1 = new TbUser();
        user1.setName("joe");
        user1.setAge(25);
        user1.setPassword("111111");
        userService.saveUser(user1);
        log.info("db1的");
        return "ok";
    }

    @RequestMapping(value = "/addUsers",method = RequestMethod.GET,name = "新增用户s")
    public String addUsers(){
        TbUsers user1 = new TbUsers();
        user1.setName("an");
        user1.setAge(23);
        user1.setPassword("111111");
        usersService.addUser(user1);
        log.info("db2的");
        return "ok";
    }
}
