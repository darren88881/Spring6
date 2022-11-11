package com.power.node.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面1
 * @Author darren
 * @Date 2022/11/11 9:53
 */
@Component
@Aspect
@Order(1)
public class UserSecondAspect {

    /**
     * 通用切点
     */
    @Pointcut("execution(* com.power.node.spring6.service.*.*())")
    public void universalPointcut(){

    }

    /**
     * 通知+切点
     */
    @Before("universalPointcut()")
    public void enhance(){
        System.out.println("UserSecondAspect：代码再次增强");
    }

    /**
     * 通知+切点
     */
    @Around("universalPointcut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("UserSecondAspect：前环绕");
        // 继续
        joinPoint.proceed();
        System.out.println("UserSecondAspect：后环绕");
    }
}
