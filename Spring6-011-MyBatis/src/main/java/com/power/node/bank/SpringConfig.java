package com.power.node.bank;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 *
 * @Author darren
 * @Date 2022/11/23 19:15
 */
@ComponentScan("com.power.node.bank")
@EnableAspectJAutoProxy
public class SpringConfig {

    @Bean(name = "myDruidDataSource")
    public DruidDataSource getDruidDataSource(){
        DruidDataSource myDruidDataSource = new DruidDataSource();
        myDruidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        myDruidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        myDruidDataSource.setUsername("root");
        myDruidDataSource.setPassword("root");
        return myDruidDataSource;
    }

    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DruidDataSource myDruidDataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(myDruidDataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config2.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.power.node.bank.mapper");
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer getMapperScan(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.power.node.bank.mapper");
        return mapperScannerConfigurer;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager(DruidDataSource myDruidDataSource) {
        DataSourceTransactionManager dataSourceTransactionManager =
                new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(myDruidDataSource);
        return dataSourceTransactionManager;
    }
}
