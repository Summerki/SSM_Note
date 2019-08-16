package com.suki;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void m(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        userService.login();

//        HumanService humanService = (HumanService) ctx.getBean("humanService");
//        humanService.login();
//        userService.logout();
    }

}
