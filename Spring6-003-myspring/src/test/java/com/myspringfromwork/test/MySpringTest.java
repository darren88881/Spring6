package com.myspringfromwork.test;

import com.power.node.myspring.bean.UserService;
import org.junit.Test;
import org.myspringfromwork.core.ClassPathXmlApplicationContext;

/**
 *
 * @Author darren
 * @Date 2022/11/4 15:29
 */
public class MySpringTest {

    @Test
    public void test01() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("myspring.xml");
        Object user = classPathXmlApplicationContext.getBean("user");
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");
        System.out.println(user);
        userService.save();
    }

}
