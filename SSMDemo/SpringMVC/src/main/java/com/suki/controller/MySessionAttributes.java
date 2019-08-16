package com.suki.controller;

import com.suki.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"user", "people"})
public class MySessionAttributes {

    @ModelAttribute("user")
    public User user(){
        User user = new User();
        user.setUsername("雄安");
        user.setPassword("321");
        return user;
    }

    @ModelAttribute("people")
    public String people(){
        return "人people";
    }

    @RequestMapping("login2")
    public String login(){
        return "suc";
    }
}
