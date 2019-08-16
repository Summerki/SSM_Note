package com.suki.controller;

import com.suki.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // 加了这个之后类里面的代码都不用写@ResponseBody注解了，自动具有@ResponseBody功能
public class MyRestController {

    @RequestMapping("rc")
    public User rc(){
        User user = new User();
        user.setUsername("测试restcontroller");
        user.setPassword("321");
        return user;
    }

}
