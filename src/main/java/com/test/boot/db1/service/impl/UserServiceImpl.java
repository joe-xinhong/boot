package com.test.boot.db1.service.impl;

import com.test.boot.db1.mapper.TbUserMapper;
import com.test.boot.db1.service.UserService;
import com.test.boot.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public void saveUser(TbUser user) {
        userMapper.insertSelective(user);
    }
}
