package com.suki.controller;

import com.suki.exp.LovelessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyExceptionHandler {

    @ExceptionHandler(LovelessException.class)
    public ModelAndView lovelessException(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "没人爱正常");
        mav.setViewName("error");  // 结合springmvc定义的前缀和后缀跳转到 /jsp/error.jsp 页面去
        return mav;
    }


    @RequestMapping("login4")
    public String login(){
        throw new LovelessException("真的没人爱吗");  // 抛出这个自定义异常
    }

}
