package com.power.node.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工厂
 * @Author darren
 * @Date 2022/11/2 8:28
 */
public class DateFactoryBean implements FactoryBean<Date> {
    private String birth;

    public DateFactoryBean(final String birth) {
        this.birth = birth;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(birth);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
