package com.power.node.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @Author darren
 * @Date 2022/11/11 10:41
 */
@Aspect
@Component
@Order(0)
public class OrderAspect {
    @Before("execution(* com.power.node.spring6.service.*.*())")
    public void enhance(){
        System.out.println("我是一个通知，代码初次增强");
    }
}
