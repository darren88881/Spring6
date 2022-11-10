package com.power.node.statics.proxy;

/**
 * 静态代理-公共接口
 * @Author darren
 * @Date 2022/11/10 8:43
 */
public interface OrderService {
    /**
     * 保存订单
     */
    void save();

    /**
     * 删除订单
     */
    String deleteOrder(String orderNum);
}
