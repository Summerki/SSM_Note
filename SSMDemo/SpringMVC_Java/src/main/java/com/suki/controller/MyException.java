package com.suki.controller;

import com.suki.exp.NoLoveException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyException {

    @RequestMapping("exp")
    public String test(){
        throw new NoLoveException("测试异常");
    }

}
