package com.powernode.spring6.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 *
 * @Author darren
 * @Date 2022/10/27 20:24
 */
public class FirstSpringTest {

    @Test
    public void testFirstSpringTest(){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");

        applicationContext.getBean("userBean");

    }
}
