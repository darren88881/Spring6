package com.power.node.spring6.design;

/**
 * 匕首工厂
 * -具体工厂
 * @Author darren
 * @Date 2022/10/31 14:17
 */
public class DaggerFactory extends WeaponFactory {
    @Override
    public Weapon get() {
        return new Dagger();
    }
}
