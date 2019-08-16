package com.suki.dao.impl;

import com.suki.dao.UserDao;
import org.springframework.stereotype.Component;

@Component
public class SuperUserDaoImpl implements UserDao {
    @Override
    public void login() {
        System.out.println("VIP数据库操作!");
    }
}
