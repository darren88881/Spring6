package com.powernode.spring6.test;

import com.powernode.spring6.bean.Dog;
import com.powernode.spring6.bean.User;
import com.powernode.spring6.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 *
 * @Author darren
 * @Date 2022/10/27 20:24
 */
public class FirstSpringTest {

    private ApplicationContext applicationContext;
    @Before
    public void beforeTest(){
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void testFirstSpringTest(){
        User userBean = applicationContext.getBean("user", User.class);
        System.out.println(userBean);
        UserService userService1 = applicationContext.getBean("userService1", UserService.class);
        UserService userService2 = applicationContext.getBean("userService2", UserService.class);
        userService1.saveUser();
        userService2.saveUser();
    }

    @Test
    public void testPAndCBean(){
        Dog dogBlack = applicationContext.getBean("dogBlack", Dog.class);
        Dog dogFlower = applicationContext.getBean("dogFlower", Dog.class);
        System.out.println(dogBlack);
        System.out.println(dogFlower);
    }
}
