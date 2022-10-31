package com.power.node.spring6.design;

/**
 * 枪
 * @Author darren
 * @Date 2022/10/31 14:14
 */
public class Gun extends Weapon{
    @Override
    public void attack() {
        System.out.println("开枪射击");
    }
}
