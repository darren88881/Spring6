package com.power.node.test;

import com.power.node.pojo.Account;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @Author darren
 * @Date 2022/11/23 10:20
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring.xml")
public class Junit5Test {

    @Autowired
    private Account mAccount;

    @BeforeAll
    public static void testBeforeClass(){
        System.out.println("被注解的（静态）方法将在当前类中的所有 @Test 方法前执行一次。");
    }

    @BeforeEach
    public void testBefore(){
        System.out.println("被注解的方法将在当前类中的每个 @Test 方法前执行。");
    }

    @Test
    public void test01(){
        System.out.println(mAccount.toString());
    }

    @AfterEach
    public void testAfter(){
        System.out.println("被注解的方法将在当前类中的每个 @Test 方法后执行。");
    }

    @AfterAll
    public static void testAfterClass(){
        System.out.println("被注解的（静态）方法将在当前类中的所有 @Test 方法后执行一次。");
    }

    @Disabled
    public void testIgnore(){
        System.out.println("被注解的方法不会执行（将被跳过），但会报告为已执行");
    }

}
