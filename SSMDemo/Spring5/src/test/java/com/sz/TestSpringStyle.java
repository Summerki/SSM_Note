package com.sz;

import com.sz.pojo.User;
import com.sz.service.PayService;
import com.sz.service.UserService;
import com.sz.service.impl.PlayerServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringStyle {

        @Test
        public void m1(){
            // 1. 读取配置文件
            // 类路径下可以使用XML形式的实现类
            ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");

            PayService payService = (PayService) ctx.getBean("payService");
            System.out.println(payService);

            System.out.println(payService.getWxPay());

            payService.getWxPay().pay();
        }
}
