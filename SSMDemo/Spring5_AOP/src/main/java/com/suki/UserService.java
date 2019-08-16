package com.suki;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    public void login(){
        System.out.println("我现在要去登陆");
    }

    public void logout(){
        System.out.println("我要下线了");
    }

}
