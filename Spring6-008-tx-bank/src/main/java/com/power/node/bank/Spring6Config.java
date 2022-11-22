package com.power.node.bank;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @Author darren
 * @Date 2022/11/22 18:23
 */
@ComponentScan("com.power.node.bank")
@EnableTransactionManagement
public class Spring6Config {

    @Bean(name = "myDruidDataSource")
    public DruidDataSource getDruidDataSource(){
        DruidDataSource myDruidDataSource = new DruidDataSource();
        myDruidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        myDruidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        myDruidDataSource.setUsername("root");
        myDruidDataSource.setPassword("root");
        return myDruidDataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DruidDataSource myDruidDataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(myDruidDataSource);
        return jdbcTemplate;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager(DruidDataSource myDruidDataSource){
        DataSourceTransactionManager dataSourceTransactionManager =
                new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(myDruidDataSource);
        return dataSourceTransactionManager;
    }
}
