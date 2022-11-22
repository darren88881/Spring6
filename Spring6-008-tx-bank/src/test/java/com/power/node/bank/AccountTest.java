package com.power.node.bank;

import com.power.node.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @Author darren
 * @Date 2022/11/16 11:02
 */
public class AccountTest {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = classPathXmlApplicationContext.getBean("accountService",
                AccountService.class);

        accountService.transfer("act-001","act-002",1000.00);
        System.out.println("转账成功");

    }

}
