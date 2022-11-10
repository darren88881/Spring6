package com.power.node.statics.proxy;

/**
 * 静态代理-代理对象
 * @Author darren
 * @Date 2022/11/10 8:45
 */
public class OrderServiceProxy implements OrderService{

    private OrderService mOrderService;

    public OrderServiceProxy(final OrderService orderService) {
        mOrderService = orderService;
    }

    @Override
    public void save() {
        long begin = System.currentTimeMillis();
        mOrderService.save();
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - begin)+"毫秒");
    }
}
