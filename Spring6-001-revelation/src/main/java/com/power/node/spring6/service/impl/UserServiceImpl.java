package com.power.node.spring6.service.impl;

import com.power.node.spring6.dao.UserDao;
import com.power.node.spring6.service.UserService;
import com.power.node.spring6.dao.impl.UserDaoImplForMySql;

public class UserServiceImpl implements UserService {
    @Override
    public void deleteUser() {
        UserDao userDao = new UserDaoImplForMySql();
        userDao.deleteById();
    }
}
