package com.suki.config;

import com.suki.pojo.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration  // 标记这个注解之后，它就具备了配置的能力，等同于app.xml
@ComponentScan(basePackages = {"com.suki.service", "com.suki.dao"})
@ImportResource(locations = "classpath:app.xml")
public class AppConfig {

    // 注册一个bean
//    @Bean  // 注册一个bean
//    public Cat cat(){
//        Cat cat = new Cat();
//        cat.setLeg(4);
//        cat.setSkin("金色");
//        return cat;
//    }

}
