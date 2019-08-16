package com.suki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyCookieValue {

    @RequestMapping("cookie")
    public void cookie(@CookieValue("JSESSIONID")String id){  // 读取cookie信息中键为"JSESSIONID"对应的值
        System.out.println(id);
    }

}
