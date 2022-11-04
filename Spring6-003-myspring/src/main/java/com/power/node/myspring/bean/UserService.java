package com.power.node.myspring.bean;

/**
 *
 * @Author darren
 * @Date 2022/11/4 15:49
 */
public class UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(final UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.insert();
    }
}
