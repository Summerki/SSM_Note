package com.suki.controller;

import com.suki.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("login")  // 这里可以写/开头，springmvc默认就会添加一个/所以就可以省略不写/了
    public String login(User user){

        System.out.println(user);

        return "suc";
    }

}
