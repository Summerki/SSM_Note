package com.suki.controller;

import com.suki.model.Love;
import com.suki.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("love")
public class LoveController {

    @Autowired
    private LoveService loveService;

    @RequestMapping("save")
    public String save(Love love){
        loveService.save(love);
        return "love/list";
    }


    // 测试查询
    // 弄了好久不知道哪里出错了，结果把 web.xml 删除之后就可以了。。。
    @GetMapping("get/{id}")
    public String get(@PathVariable("id")long id, Model model){
        Love love = loveService.get(id);
        System.out.println(love);
        model.addAttribute("love", love);  // 将根据id查询出来的love对象增加到request域中
        return "love/detail";
    }
}
