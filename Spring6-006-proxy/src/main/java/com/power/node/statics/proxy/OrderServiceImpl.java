package com.power.node.statics.proxy;

/**
 * 静态代理目标对象
 * @Author darren
 * @Date 2022/11/10 8:44
 */
public class OrderServiceImpl implements OrderService{
    @Override
    public void save() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("保存订单");
    }

    @Override
    public String deleteOrder(String orderNum) {
        try {
            Thread.sleep(1050);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("删除订单:"+orderNum);
        return "订单已删除";
    }
}
