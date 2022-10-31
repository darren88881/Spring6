package com.power.node.spring6.bean;

/**
 * 明星工厂
 * @Author darren
 * @Date 2022/10/31 14:57
 */
public class StarFactory {
    public static Star get(){
        return new Star();
    }
}
