package com.power.node.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面0
 * @Author darren
 * @Date 2022/11/11 10:41
 */
@Aspect
@Component
@Order(0)
public class UserFirstAspect {
    /**
     * 通知+切点
     */
    @Before("execution(* com.power.node.spring6.service.*.*())")
    public void enhance(){
        System.out.println("UserFirstAspect：代码第一次增强");
    }
}
