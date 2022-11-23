package com.power.node.bank.test;

import com.power.node.bank.pojo.Account;
import com.power.node.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @Author darren
 * @Date 2022/11/23 18:11
 */
public class SpringMyBatisTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
//        Account account = accountService.selectAccountByActno("act-001");
//        System.out.println(account);
        accountService.transfer("act-001","act-002", 1000.00);
    }
}
