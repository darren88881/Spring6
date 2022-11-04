package com.power.node.spring6.test;

import com.power.node.spring6.bean.BeanLifeCycle;
import com.power.node.spring6.cycle.Husband;
import com.power.node.spring6.cycle.Wife;
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
     * Spring容器只对singleton的Bean进行完整的生命周期管理
     * 如果是prototype作用域的Bean, Spring容器只负责将源Bean初始化完毕,
     * 等客户端程序一旦获取到该Bean之后,Spring容器就不再管理该对象的生命周期了。
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

    /**
     * 测试循环依赖
     */
    @Test
    public void testCycleTest(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("cycle.xml");
        Husband husband = classPathXmlApplicationContext.getBean("husband",
                Husband.class);
        Wife wife = classPathXmlApplicationContext.getBean("wife",
                Wife.class);
        System.out.println(husband.toString());
        System.out.println(wife.toString());
    }
}
