package com.power.node.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 *
 * @Author darren
 * @Date 2022/10/31 15:40
 */
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
