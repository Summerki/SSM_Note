package com.suki.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

// 配置文件通过注解的方式的配置类
@Configuration
@ComponentScan(basePackages = {"com.suki.controller"})
public class Appconfig {

    // 注册视图解析器
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver rs = new InternalResourceViewResolver();
        rs.setPrefix("/");
        rs.setSuffix(".jsp");
        return rs;
    }

    // 添加文件上传解析器
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver cr = new CommonsMultipartResolver();
        cr.setMaxUploadSize(1024*1024*1024);  // bytes
        cr.setDefaultEncoding("UTF-8");  // 设置编码，让其支持中文
        return cr;
    }

    // 注册一个异常解析器
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver sr = new SimpleMappingExceptionResolver();
        Properties mapping = new Properties();
        mapping.setProperty("com.suki.exp.NoLoveException", "exp");
        sr.setExceptionMappings(mapping);
        return sr;
    }

}
