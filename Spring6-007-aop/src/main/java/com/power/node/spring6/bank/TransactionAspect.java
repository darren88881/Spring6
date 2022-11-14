package com.power.node.spring6.bank;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 * @Author darren
 * @Date 2022/11/14 10:12
 */
@Component
@Aspect
public class TransactionAspect {

    @Around("execution(* com.power.node.spring6.bank.BankService.*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("开启事务");
            joinPoint.proceed();
            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
            throw new RuntimeException(e);
        }
    }
}
