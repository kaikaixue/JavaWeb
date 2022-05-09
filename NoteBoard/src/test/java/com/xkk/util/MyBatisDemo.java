package com.xkk.util;

import com.xkk.bean.DO.UserDO;
import com.xkk.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisDemo {
    @Test
    public void test01() throws IOException {
        //1.加载mybitis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSessionFactory对象，用它来执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //3.执行sql
        UserDO userDO = userMapper.getInfo(1);
        //selectOne查找一个
        System.out.println(userDO);
        //4.释放资源
        sqlSession.close();
    }
}
