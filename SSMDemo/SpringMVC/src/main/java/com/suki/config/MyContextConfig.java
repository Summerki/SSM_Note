package com.suki.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextConfig implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(sce.getServletContext().getContextPath());  // 返回 /springmvc
        sce.getServletContext().setAttribute("ctx", sce.getServletContext().getContextPath());
    }
}
