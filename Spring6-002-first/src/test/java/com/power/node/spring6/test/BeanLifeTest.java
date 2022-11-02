package com.power.node.spring6.test;

import com.power.node.spring6.bean.BeanLifeCycle;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean的生命周期
 * @Author darren
 * @Date 2022/11/2 10:36
 */
public class BeanLifeTest {
    /**
     * Bean的生命周期
     */
    @Test
    public void testBeanLifeCycle(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("beanLife.xml");
        BeanLifeCycle beanLife = classPathXmlApplicationContext.getBean("beanLife", BeanLifeCycle.class);
        System.out.println("第四步:使用Bean "+beanLife.toString());
        System.out.println("");

        classPathXmlApplicationContext.close();
    }
}
