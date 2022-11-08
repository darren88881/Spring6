package com.power.node;

import com.power.node.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @Author darren
 * @Date 2022/11/8 9:44
 */
public class test {

    private JdbcTemplate jdbcTemplate;

    @Before
    public void getJdbcTemplate(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        jdbcTemplate = classPathXmlApplicationContext.getBean("jdbcTemplate",
                JdbcTemplate.class);
    }

    @Test
    public void test01(){
        String sql = "insert into user(name, age) values (?,?)";
        jdbcTemplate.update(sql, "赵绍明", 29);
    }

    @Test
    public void test02(){
        String sql = "select * from user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> userList = jdbcTemplate.query(sql, rowMapper);
        System.out.println(userList);
    }

    @Test
    public void test03(){
        String sql = "select * from user where id=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper,1);
        System.out.println(user);
    }

    /**
     * 查询一个值
     */
    @Test
    public void test04(){
        String sql = "select count(*) from user";
        int count = jdbcTemplate.queryForObject(sql, int.class);
        System.out.println(count);
    }

    /**
     * 批量添加
     */
    @Test
    public void test05(){
        String sql = "insert into user(name, age) values(?,?)";
        ArrayList<Object[]> users = new ArrayList<Object[]>();
        users.add(new Object[]{"杨浩",30});
        users.add(new Object[]{"杨广",31});
        users.add(new Object[]{"杨坚",33});
        int[] ints = jdbcTemplate.batchUpdate(sql, users);
        System.out.println(Arrays.toString(ints));
    }
}
