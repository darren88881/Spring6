package com.power.node.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 实例化前后处理器
 * @Author darren
 * @Date 2022/11/2 17:16
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(final Class<?> beanClass, final String beanName)
            throws BeansException {
        System.out.println("    第1.1步-实例化之前-后期处理器");
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass,
                beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, final String beanName)
            throws BeansException {
        System.out.println("    第1.1步-实例化之后-后期处理器");
        System.out.println("");
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean,
                beanName);
    }
}
