package com.suki.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Async
    @RequestMapping("hello")
    public String hello(){
        return "suc";
    }

}
