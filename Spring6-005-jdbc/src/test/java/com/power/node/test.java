package com.power.node;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @Author darren
 * @Date 2022/11/8 9:44
 */
public class test {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = classPathXmlApplicationContext.getBean("jdbcTemplate",
                JdbcTemplate.class);
        String sql = "insert into user(name, age) values (?,?)";
        jdbcTemplate.update(sql, "赵绍明", 29);
    }
}
