package com.suki.controller;

import com.suki.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {


    @ModelAttribute
    public User user(){
        User user = new User();
        user.setUsername("考试大帝");
        return user;
    }

    @RequestMapping("exam")
    public String exam(){
        System.out.println("参加考试");
        return "suc";
    }
}
