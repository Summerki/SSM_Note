package com.suki.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.suki.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PathController {

    @RequestMapping("delete/{id}") // 避免了写delete?id=xxx这种麻烦形式
    public String delete(@PathVariable("id")Long id){
        System.out.println(id);
        return "suc";
    }


    @RequestMapping(value = "requestBody", method = RequestMethod.POST)
    @ResponseBody
    public String post(@RequestBody User user){
        System.out.println(user);
        return "suc";
    }
}
