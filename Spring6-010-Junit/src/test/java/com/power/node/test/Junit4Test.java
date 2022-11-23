package com.power.node.test;

import com.power.node.pojo.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @Author darren
 * @Date 2022/11/23 10:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class Junit4Test {

    @Autowired
    private Account mAccount;

    @BeforeClass
    public static void testBeforeClass(){
        System.out.println("被注解的（静态）方法将在当前类中的所有 @Test 方法前执行一次。");
    }

    @Before
    public void testBefore(){
        System.out.println("被注解的方法将在当前类中的每个 @Test 方法前执行。");
    }

    @Test
    public void test01(){
        System.out.println(mAccount.toString());
    }

    @After
    public void testAfter(){
        System.out.println("被注解的方法将在当前类中的每个 @Test 方法后执行。");
    }

    @AfterClass
    public static void testAfterClass(){
        System.out.println("被注解的（静态）方法将在当前类中的所有 @Test 方法后执行一次。");
    }

    @Ignore
    public void testIgnore(){
        System.out.println("被注解的方法不会执行（将被跳过），但会报告为已执行");
    }

    /**
     * 测试断言
     * message：错误消息
     * expected:期望值
     * actual：测试数据
     * float：精度值
     */
    @Test
    public void testAssert(){
        int [] a = new int[]{1,2,3};
        int [] b = new int[]{1,2,3};
        Assert.assertArrayEquals(a,b);
        Assert.assertEquals(2f, 3f, 2f);
    }

    @Test
    public void testAssertionError(){
        Assert.assertEquals("他们不一样","abc","bc");
    }
}
