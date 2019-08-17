package com.suki.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * mybatis注解配置
 * 参考：mybatis-spring  http://www.mybatis.org/spring/zh/getting-started.html
 */
@Configuration
@PropertySource(value = "classpath:db.properties")
// 使用通用mapper下的注解
// 参考：https://github.com/abel533/Mapper/wiki/1.2-spring
@MapperScan(value = {"tk.mybatis.mapper.annotation","com.suki.mapper"}, mapperHelperRef = "mapperHelper")
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

        // 设置分页插件pagehelper
        Properties pageProps = new Properties();
        // 参考：https://github.com/abel533/Mybatis-Spring
        pageProps.setProperty("helperDialect", "mysql");  // 用哪个数据库
        pageProps.setProperty("reasonable", "true");
        pageProps.setProperty("supportMethodsArguments", "true");
        pageProps.setProperty("params", "count=countSql");
        pageProps.setProperty("autoRuntimeDialect", "true");
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(pageProps);
        sqlSessionFactoryBean.setPlugins(pageInterceptor);  // 设置插件

        return sqlSessionFactoryBean;
    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        //tk.mybatis.mapper.session.Configuration
//        tk.mybatis.mapper.session.Configuration configuration = new tk.mybatis.mapper.session.Configuration();
//        //可以对 MapperHelper 进行配置后 set
//        configuration.setMapperHelper(new MapperHelper());
//        //设置为 tk 提供的 Configuration
//        sessionFactory.setConfiguration(configuration);
//        return sessionFactory.getObject();
//    }


    // 注册事务
    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }


    //
    @Bean
    public MapperHelper mapperHelper(){
        Config config = new Config();
        List<Class> mappers = new ArrayList<>();
        mappers.add(Mapper.class);
        config.setMappers(mappers);

        MapperHelper mapperHelper = new MapperHelper();
        mapperHelper.setConfig(config);
        return mapperHelper;
    }
}
