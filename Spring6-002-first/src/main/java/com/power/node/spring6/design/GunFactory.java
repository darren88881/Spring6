package com.power.node.spring6.design;

/**
 * 枪工厂-具体工厂
 * @Author darren
 * @Date 2022/10/31 14:19
 */
public class GunFactory extends WeaponFactory{
    @Override
    public Weapon get() {
        return new Gun();
    }
}
