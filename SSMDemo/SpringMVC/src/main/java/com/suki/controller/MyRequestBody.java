package com.suki.controller;

import com.suki.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyRequestBody {

    @RequestMapping("requestBody")
    public User post(@RequestBody User user){
        System.out.println(user);
        return user;
    }

}
