package com.pwoer.node.test;

import com.power.node.ConfigurationClass;
import com.power.node.component.UserComponent;
import com.power.node.repository.UserDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @Author darren
 * @Date 2022/11/8 8:43
 */
public class UserTest {

    /**
     * 测试注解扫描
     */
    @Test
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        UserComponent userComponent = classPathXmlApplicationContext.getBean("userComponent",
                UserComponent.class);
        System.out.println(userComponent);
    }

    /**
     * 测试Configuration
     */
    @Test
    public void test02(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(ConfigurationClass.class);
        UserDao userDao = annotationConfigApplicationContext.getBean("userDao", UserDao.class);
        System.out.println(userDao);
    }
}
