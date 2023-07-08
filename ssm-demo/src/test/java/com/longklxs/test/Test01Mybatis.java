package com.longklxs.test;

import com.longklxs.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;


public class Test01Mybatis {
    @Test
    public void test01() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        System.out.println(mapper.findAll());

    }
}
