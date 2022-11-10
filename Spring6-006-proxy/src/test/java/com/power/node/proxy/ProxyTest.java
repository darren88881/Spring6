package com.power.node.proxy;

import com.power.node.jdk.proxy.MyInvocationHandler;
import com.power.node.statics.proxy.OrderService;
import com.power.node.statics.proxy.OrderServiceImpl;
import com.power.node.statics.proxy.OrderServiceProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @Author darren
 * @Date 2022/11/10 8:48
 */
public class ProxyTest {

    /**
     * 静态代理测试
     *
     * 1）代理类和委托类实现了相同的接口，代理类通过委托类实现了相同的方法。这样就出现了大量的代码重复。
     * 如果接口增加一个方法，除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度。
     *
     * 2）代理对象只服务于一种类型的对象，如果要服务多类型的对象。
     * 势必要为每一种对象都进行代理，静态代理在程序规模稍大时就无法胜任了
     */
    @Test
    public void staticProxyTest(){
        OrderService orderService = new OrderServiceProxy(new OrderServiceImpl());
        orderService.save();
    }

    /**
     * JDK动态代理
     * ClassLoader：代理类的类加载器
     * interfaces：代理类实现的接口列表
     * InvocationHandler：调用处理程序
     */
    @Test
    public void jdkProxyTest(){
        OrderService orderService = new OrderServiceImpl();
        OrderService invoke =(OrderService) Proxy.newProxyInstance(
                orderService.getClass().getClassLoader(),
                orderService.getClass().getInterfaces(),
                new MyInvocationHandler(orderService));
        invoke.deleteOrder("1111");
    }
}
