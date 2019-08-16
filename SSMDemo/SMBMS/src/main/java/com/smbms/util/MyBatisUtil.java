package com.smbms.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis工具类
 */
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        // 1. 读取核心的配置文件
        String resource = "mybatis.cfg.xml";
        InputStream in = null;

        try {
            in = Resources.getResourceAsStream(resource);
            // 3. 使用SqlSessionFactoryBuilder来构建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession createSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
