package com.power.node.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面
 * @Author darren
 * @Date 2022/11/11 9:53
 */
@Component
@Aspect
@Order(1)
public class LogAspect {

    /**
     * 通用切点
     */
    @Pointcut("execution(* com.power.node.spring6.service.*.*())")
    public void universalPointcut(){

    }

    @Before("universalPointcut()")
    public void enhance(){
        System.out.println("LogAspect：代码再次增强");
    }

    @Around("universalPointcut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("LogAspect：前环绕");
        // 继续
        joinPoint.proceed();
        System.out.println("LogAspect：后环绕");
    }
}
