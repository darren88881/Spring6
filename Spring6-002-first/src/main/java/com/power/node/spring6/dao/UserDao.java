package com.power.node.spring6.dao;

import java.util.logging.Logger;

/**
 *
 * @Author darren
 * @Date 2022/10/28 10:06
 */
public class UserDao {
    private static Logger loggerUserDao = Logger.getLogger("UserDao");

    public void saveUserDao(){
        loggerUserDao.info("保存数据成功");
    }
}
