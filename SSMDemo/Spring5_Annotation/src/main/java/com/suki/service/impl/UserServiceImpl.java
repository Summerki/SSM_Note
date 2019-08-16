package com.suki.service.impl;

import com.suki.dao.UserDao;
import com.suki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired()
    @Qualifier("superUserDaoImpl")
    private UserDao userDao;

    @Override
    public void login() {
        System.out.println("test");
        userDao.login();
    }
}
