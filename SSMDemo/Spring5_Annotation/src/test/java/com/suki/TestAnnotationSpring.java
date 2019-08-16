package com.suki;

import com.suki.config.AppConfig;
import com.suki.pojo.Cat;
import com.suki.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotationSpring {

    @Test
    public void test(){
        // 完成注解模式的上下文的初始化
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cat bean = context.getBean(Cat.class);
        System.out.println(bean);
    }

}
