package com.power.node.spring6.reflection;

/**
 * 反射类
 * @Author darren
 * @Date 2022/11/4 10:19
 */
public class ReflectionClass {

    public void doMethod(){
        System.out.println("doMethod() 方法执行");
    }

    public void doMethod(String name){
        System.out.println("doMethod(String "+ name +") 方法执行");
    }
}
