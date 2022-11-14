package com.power.node.test;

import com.power.node.spring6.Student.StudentService;
import com.power.node.spring6.bank.BankService;
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
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = classPathXmlApplicationContext.getBean("userService",
                UserService.class);
        userService.loggin();
    }

    /**
     * 全注解开发
     */
    @Test
    public void notXmlTest(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Spring6Config.class);
        UserService userService = annotationConfigApplicationContext.getBean("userService",
                UserService.class);
        userService.loggin();
    }

    /**
     * 全XML配置开发
     */
    @Test
    public void XmlTest(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("student.xml");
        StudentService studentService = classPathXmlApplicationContext.getBean("studentService",
                StudentService.class);
        studentService.myName();
    }

    /**
     * 测试银行转账开启事务环绕通知
     */
    @Test
    public void bankTest(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        BankService bankService = classPathXmlApplicationContext.getBean("bankService",
                BankService.class);
        bankService.getMoney();

    }
}
