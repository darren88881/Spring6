package com.power.node.spring6.dao.impl;

import com.power.node.spring6.dao.UserDao;

public class UserDaoImplForMySql implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("Mysql 数据库正在删除用户信息...");
    }
}
