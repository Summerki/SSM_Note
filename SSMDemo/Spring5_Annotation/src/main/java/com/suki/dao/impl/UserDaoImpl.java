package com.suki.dao.impl;

import com.suki.dao.UserDao;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    @Override
    public void login() {
        System.out.println("test 数据库操作");
    }
}
