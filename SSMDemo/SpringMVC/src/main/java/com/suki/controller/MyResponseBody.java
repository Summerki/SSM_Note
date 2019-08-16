package com.suki.controller;

import com.suki.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyResponseBody {

    @RequestMapping("responseBody")
    @ResponseBody
    public User response(){
        User user = new User();
        user.setUsername("测试response");
        user.setPassword("1234");
        return user;
    }

}
