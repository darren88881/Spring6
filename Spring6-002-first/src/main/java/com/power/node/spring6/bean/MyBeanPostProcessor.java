package com.power.node.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 初始化前后置处理器
 * @Author darren
 * @Date 2022/11/2 9:56
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName)
            throws BeansException {
        System.out.println("    第3.1步-初始化前的-后期处理器");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);

    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName)
            throws BeansException {
        System.out.println("    第3.2步-初始化后的-后期处理器");
        System.out.println("");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
