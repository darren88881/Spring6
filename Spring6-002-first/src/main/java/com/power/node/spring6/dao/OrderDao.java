package com.power.node.spring6.dao;

import java.util.logging.Logger;

/**
 *
 * @Author darren
 * @Date 2022/10/28 10:22
 */
public class OrderDao {
    private Logger logger = Logger.getLogger("OrderDao");

    public void saverOrderDao(){
        logger.info("保存Order成功");
    }
}
