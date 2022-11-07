package com.myspringfromwork.test;

import org.dom4j.DocumentException;
import org.junit.Test;
import org.myspringfromwork.core.ClassPathXmlApplicationContext;

/**
 *
 * @Author darren
 * @Date 2022/11/4 15:29
 */
public class MySpringTest {

    @Test
    public void test01() throws DocumentException {

        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("myspring.xml");
    }


}
