package com.suki.controller;

import com.suki.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class MySessionAttribute {

    @RequestMapping("login1")
    public String login(HttpSession session){
        User user = new User();
        user.setUsername("测试");
        user.setPassword("321");
        session.setAttribute("sessionUser", user);
        return "suc";
    }


    @RequestMapping("exam1")
    public String exam(@SessionAttribute("sessionUser")User user){
        System.out.println("sessionUser为" + user.getUsername() + "==" + user.getPassword());
        return "suc";
    }

}
