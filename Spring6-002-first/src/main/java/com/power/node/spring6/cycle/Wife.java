package com.power.node.spring6.cycle;

/**
 * 妻子类
 * @Author darren
 * @Date 2022/11/3 14:25
 */
public class Wife {
    private String name;
    private Husband husband;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(final Husband husband) {
        this.husband = husband;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }
}
