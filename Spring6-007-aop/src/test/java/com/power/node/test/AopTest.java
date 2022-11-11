package com.power.node.test;

import com.power.node.spring6.service.Spring6Config;
import com.power.node.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @Author darren
 * @Date 2022/11/11 10:13
 */
public class AopTest {

    @Test
    public void notXmlTest(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Spring6Config.class);
        UserService userService = annotationConfigApplicationContext.getBean("userService",
                UserService.class);
        userService.loggin();
    }

    @Test
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = classPathXmlApplicationContext.getBean("userService",
                UserService.class);
        userService.loggin();
    }
}
