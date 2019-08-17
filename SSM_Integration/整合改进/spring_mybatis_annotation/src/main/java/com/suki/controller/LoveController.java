package com.suki.controller;

import com.github.pagehelper.PageInfo;
import com.suki.dto.ResponseCode;
import com.suki.model.Love;
import com.suki.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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


//    // 测试查询
//    // 弄了好久不知道哪里出错了，结果把 web.xml 删除之后就可以了。。。
//    @GetMapping("get/{id}")
//    public String get(@PathVariable("id")long id, Model model){
//        Love love = loveService.get(id);
//        System.out.println(love);
//        model.addAttribute("love", love);  // 将根据id查询出来的love对象增加到request域中
//        return "love/detail";
//    }


    // 测试json数据交互！！！！
    @GetMapping("get/{id}")
    @ResponseBody  // 测试json数据交互
    public Love get(@PathVariable("id")long id){
        Love love = loveService.get(id);
        System.out.println(love);
        return love;
    }


    @PostMapping("update")
    public String update(Love love){
        loveService.update(love);
        return "love/detail";
    }


    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseCode delete(@PathVariable("id")long id){
        ResponseCode code = loveService.delete(id);
        return code;  // 测试DTO中的自定义响应码code功能
    }

    // 测试分页查询
    @RequestMapping("query")
    public String query(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize){
        PageInfo<Love> pageInfo = loveService.query(pageNum, pageSize);
        System.out.println(pageInfo);
        return "love/detail";
    }



}
