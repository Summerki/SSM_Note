package com.suki.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller  // 语义是控制器，专门用来处理请求
public class HelloController {

    @RequestMapping("hello")
    public String hello(Model model, HttpSession session, HttpServletRequest httpServletRequest){
        System.out.println("我来了 springmvc");

//        session.setAttribute("user", "user");
        httpServletRequest.setAttribute("user", "user");

        return "hello/baby";
    }
}
