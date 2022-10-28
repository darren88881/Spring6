package com.powernode.spring6.test;

import com.powernode.spring6.bean.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 *
 * @Author darren
 * @Date 2022/10/27 20:24
 */
public class FirstSpringTest {

    private Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);

    @Test
    public void testFirstSpringTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");

        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);

        logger.info(userBean+"已创建！");
    }
}
