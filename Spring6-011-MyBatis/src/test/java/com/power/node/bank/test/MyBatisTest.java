package com.power.node.bank.test;

import com.power.node.bank.mapper.AccountMapper;
import com.power.node.bank.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @Author darren
 * @Date 2022/11/23 16:48
 */
public class MyBatisTest {

    private InputStream resourceAsStream;
    private SqlSession sqlSession;

    @Before
    public void getSqlSession() throws IOException {
        String source = "mybatis-config.xml";
        resourceAsStream = Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test01() {
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accounts = mapper.selectAccountAll();
        System.out.println(accounts.toString());
    }

    @After
    public void closeSqlSession() throws IOException {
        resourceAsStream.close();
        sqlSession.close();
    }

}
