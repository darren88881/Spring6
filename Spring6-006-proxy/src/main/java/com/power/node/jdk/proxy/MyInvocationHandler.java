package com.power.node.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 自己处理程序
 * @Author darren
 * @Date 2022/11/10 12:59
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 第一个参数: Object proxy 代理对象的引用。这个参数使用较少。
     * 第二个参数: Method method 目标对象上的目标方法。(要执行的目标方法就是它。)
     * 第三个参数: Object[] args 目标方法上的实参。
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args)
            throws Throwable {
        System.out.println("invoke..");
        // deleteOrder
        System.out.println(method.getName());
        // 1111
        System.out.println(args[0].toString());
        Object invoke = method.invoke(target, args);
        return null;
    }
}
