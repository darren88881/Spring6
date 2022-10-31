package com.powernode.spring6.test;

import com.powernode.spring6.design.DaggerFactory;
import com.powernode.spring6.design.Weapon;
import org.junit.Test;

/**
 * 测试工厂模式
 * @Author darren
 * @Date 2022/10/31 14:44
 */
public class FactoryTest {

    @Test
    public void test01(){
        DaggerFactory daggerFactory = new DaggerFactory();
        Weapon weapon = daggerFactory.get();
        weapon.attack();
    }
}
