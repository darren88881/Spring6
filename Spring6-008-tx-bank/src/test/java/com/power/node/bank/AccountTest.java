package com.power.node.bank;

import com.power.node.bank.pojo.Account;
import com.power.node.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @Author darren
 * @Date 2022/11/16 11:02
 */
public class AccountTest {

    /**
     * 测试事务
     */
    @Test
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = classPathXmlApplicationContext.getBean("accountService",
                AccountService.class);

        accountService.transfer("act-001","act-002",1000.00);
        System.out.println("转账成功");

    }

    /**
     * 测试事务的传播机制
     *
     * 必需的     required		:支持当前事务,如果当前没有事务,则新建一个事务,默认使用这种,也是最常见的 。
     * 需要新的   requires_new	:新建事务,如果当前存在事务,就把当前事务挂起。
     *
     * 支持       supports		:支持当前事务,如果没有事务,就以非事务（即数据库事物）的方式执行。
     * 不支持      not_supported	:以非事务的方式执行操作,如果当前存在事务,就把当前事务挂起.
     *
     * 强制的      mandatory		:支持当前事务,如果没有事务,就抛出异常.
     * 绝不        never		:以非事务的方式执行,如果当前存在事务,则会抛出异常.
     * 嵌套        nested		:如果当前事务存在，则执行嵌套事务，否则执行类似REQUIRED的操作.
     */
    @Test
    public void test02(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = classPathXmlApplicationContext.getBean("accountService",
                AccountService.class);

        int i = accountService.addAccount(new Account("act-003", 1000.00));
        System.out.println("创建两个"+i+"账户成功");

    }

}
