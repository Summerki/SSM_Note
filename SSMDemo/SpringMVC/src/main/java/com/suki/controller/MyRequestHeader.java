package com.suki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyRequestHeader {

    @RequestMapping("login3")
    public String login(@RequestHeader("Cookie")String cookie){  // 拿到这次请求的cookie信息
        System.out.println(cookie);
        return "suc";
    }

}
