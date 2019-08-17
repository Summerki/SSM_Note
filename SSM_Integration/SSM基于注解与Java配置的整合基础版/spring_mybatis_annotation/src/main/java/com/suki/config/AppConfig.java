package com.suki.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 总配置类
 */
@Configuration
@ComponentScan(basePackages = {"com.suki.service"})
@Import({MybatisConfig.class, SpringMvcConfig.class})  // 导入其他配置类
public class AppConfig {


}
