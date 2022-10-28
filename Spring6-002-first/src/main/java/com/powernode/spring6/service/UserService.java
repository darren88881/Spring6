package com.powernode.spring6.service;

import com.powernode.spring6.dao.OrderDao;
import com.powernode.spring6.dao.UserDao;

/**
 *
 * @Author darren
 * @Date 2022/10/28 10:15
 */
public class UserService {

    private UserDao userDao;
    private OrderDao orderDao;

    /**
     * 如果写了有参构造，此处无参构造必须要，不然无法实例化导致对象无法创建
     */
    public UserService() {
    }

    public UserService(final UserDao userDao, final OrderDao orderDao) {
        this.userDao = userDao;
        this.orderDao = orderDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(final OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(final UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(){
        userDao.saveUserDao();
        orderDao.saverOrderDao();
    }
}
