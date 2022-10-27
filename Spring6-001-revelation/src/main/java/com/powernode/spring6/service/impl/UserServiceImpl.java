package com.powernode.spring6.service.impl;

import com.powernode.spring6.dao.UserDao;
import com.powernode.spring6.dao.impl.UserDaoImplForMySql;
import com.powernode.spring6.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void deleteUser() {
        UserDao userDao = new UserDaoImplForMySql();
        userDao.deleteById();
    }
}
