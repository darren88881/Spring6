package com.powernode.spring6.design;

/**
 *
 * @Author darren
 * @Date 2022/10/31 14:26
 */
public class FactoryTest {
    public static void main(String[] args) {
        DaggerFactory daggerFactory = new DaggerFactory();
        Weapon weapon = daggerFactory.get();
        weapon.attack();
    }
}
