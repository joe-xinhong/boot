package com.test.boot.db2.service.impl;

import com.test.boot.db2.mapper.TbUsersMapper;
import com.test.boot.db2.service.UsersService;
import com.test.boot.entity.TbUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private TbUsersMapper usersMapper;
    @Override
    public void addUser(TbUsers user) {
        usersMapper.insertSelective(user);
    }
}
