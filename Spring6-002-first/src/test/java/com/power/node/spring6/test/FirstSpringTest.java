package com.power.node.spring6.test;

import com.power.node.spring6.bean.Chicken;
import com.power.node.spring6.bean.Person;
import com.power.node.spring6.service.UserService;
import com.power.node.spring6.bean.Dog;
import com.power.node.spring6.bean.Star;
import com.power.node.spring6.bean.User;
import com.power.node.spring6.scope.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

/**
 * 测试类
 *
 * @Author darren
 * @Date 2022/10/27 20:24
 */
public class FirstSpringTest {

    private ApplicationContext applicationContext;
    private Logger logger;
    @Before
    public void beforeTest(){
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        logger = Logger.getLogger("FirstSpringTest");
    }

    @Test
    public void testFirstSpringTest(){
        User userBean = applicationContext.getBean("user", User.class);
        System.out.println(userBean);
        UserService userService1 = applicationContext.getBean("userService1", UserService.class);
        UserService userService2 = applicationContext.getBean("userService2", UserService.class);
        UserService userService3 = applicationContext.getBean("userService3", UserService.class);
        UserService userService4 = applicationContext.getBean("userService4", UserService.class);
        logger.info("------------------userService1 begin------------------");
        userService1.saveUser();
        logger.info("------------------userService1 end------------------");
        logger.info("------------------userService2 begin------------------");
        userService2.saveUser();
        logger.info("------------------userService2 end------------------");
        logger.info("------------------userService3 begin------------------");
        userService3.saveUser();
        logger.info("------------------userService3 end------------------");
        logger.info("------------------userService4 begin------------------");
        userService4.saveUser();
        logger.info("------------------userService4 end------------------");
    }

    @Test
    public void testPAndCBean(){
        Dog dogBlack = applicationContext.getBean("dogBlack", Dog.class);
        Dog dogFlower = applicationContext.getBean("dogFlower", Dog.class);
        Dog dogWolf = applicationContext.getBean("dogWolf", Dog.class);
        System.out.println(dogBlack);
        System.out.println(dogFlower);
        System.out.println(dogWolf);
    }

    /**
     * spring 作用域
     */
    @Test
    public void testScope(){
        Student student1 = applicationContext.getBean("student1", Student.class);
        Student student2 = applicationContext.getBean("student2", Student.class);
        // 注意这是不同的对象
        logger.info(Boolean.toString(student1.equals(student2)));//false

    }

    /**
     * 自定义作用域
     */
    @Test
    public void testThreadScope(){
        Student student3 = applicationContext.getBean("student3", Student.class);
        Student student4 = applicationContext.getBean("student3", Student.class);

        logger.info(student3.toString());//true
        logger.info(Boolean.toString(student3.equals(student4)));//true

        new Thread(()->{
            Student student5 = applicationContext.getBean("student3", Student.class);
            Student student6 = applicationContext.getBean("student3", Student.class);
            logger.info(Boolean.toString(student5.equals(student6)));//true
            logger.info(student5.toString());//true
        }).start();
    }

    /**
     * 简单工厂实例化Bean
     * 通过静态方法实例化
     */
    @Test
    public void testFactory(){
        Star star = applicationContext.getBean("star", Star.class);
        System.out.println(star);
    }

    /**
     * 工厂Bean实例化
     * 通过实例方法实例化
     */
    @Test
    public void testFactoryBean(){
        Chicken chicken = applicationContext.getBean("chicken", Chicken.class);
        System.out.println(chicken);
    }

    /**
     * 工厂Bean实例化
     * 通过实现FactoryBean实例化
     */
    @Test
    public void testPersonFactoryBean(){
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }
}
