package com.suki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A {

    @RequestMapping("a")
    public String a(){
        System.out.println("a");
        return "a";
    }

    @RequestMapping("b")
    public String b(){
        System.out.println("b");
        return "redirect:/b.jsp";  // 会重定向页面到 /springmvc/b.jsp
    }

    @RequestMapping("c")
    public String c(){
        System.out.println("c");
        return "forward:a";  // 将逻辑转发到a上，但是页面URI还是写的c
    }

    @RequestMapping("d")
    public String d(){
        System.out.println("d");
        return "redirect:a";  // 页面URI会改变成a
    }
}
