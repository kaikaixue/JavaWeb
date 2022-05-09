package com.xkk.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

//Session工具类
public class MySessionUtils {
    private static SqlSessionFactory sessionFactory;
    //static 静态代码，在类加载的时候执行一次，且只执行一次
    static {
//        1.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        2.创建SqlSessionFactory对象
//        3.加载SqlMapConfig.xml配置文件
        InputStream inputStream = MySessionUtils.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        sessionFactory = sqlSessionFactoryBuilder.build(inputStream);//加载核心配置文件 参1 输入流
    }
    public static SqlSession getSession() {

//        4.创建SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        return sqlSession;
    }
}


