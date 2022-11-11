package com.power.node.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 切面
 * @Author darren
 * @Date 2022/11/11 9:53
 */
@Component
@Aspect
public class LogAspect {

    @Before("execution(* com.power.node.spring6.service.*.*())")
    public void enhance(){
        System.out.println("我是一个通知，代码增强了");
    }
}
