package com.power.node.bank.test;

import com.power.node.bank.SpringConfig;
import com.power.node.bank.pojo.Account;
import com.power.node.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * spring 整合mybatis 测试
 * @Author darren
 * @Date 2022/11/23 18:11
 */
public class SpringMyBatisTest {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
        List<Account> accounts = accountService.selectAccountAll();
        System.out.println(accounts);
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountServiceImpl = annotationConfigApplicationContext.getBean(
                "accountServiceImpl", AccountService.class);
        List<Account> accounts = accountServiceImpl.selectAccountAll();
        System.out.println(accounts);
    }

}
