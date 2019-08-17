package com.suki.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.io.IOException;

/**
 * mybatis注解配置
 * 参考：mybatis-spring  http://www.mybatis.org/spring/zh/getting-started.html
 */
@Configuration
@PropertySource(value = "classpath:db.properties")
@MapperScan(basePackages = {"com.suki.mapper"})  // 配置扫描接口
public class MybatisConfig {

    @Value("${db.url}")
    private String url;

    @Value("${db.driver}")
    private String driver;

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Value("${db.maxActive}")
    private int maxActive;

    // 注册数据源
    @Bean(name = "dataSource")
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        return dataSource;
    }


    // 注册会话工厂
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        // 设置mapper文件映射
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(patternResolver.getResources("classpath:mapper/**/*xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // mybatis 一些系统配置
        org.apache.ibatis.session.Configuration cfg = new org.apache.ibatis.session.Configuration();
        cfg.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(cfg);  // 配置的设置
        return sqlSessionFactoryBean;
    }


    // 注册事务
    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }

}
