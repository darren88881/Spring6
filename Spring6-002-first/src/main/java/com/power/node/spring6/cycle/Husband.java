package com.power.node.spring6.cycle;

/**
 * 丈夫类
 * @Author darren
 * @Date 2022/11/3 14:25
 */
public class Husband {
    private String name;
    private Wife   wife;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(final Wife wife) {
        this.wife = wife;
    }

    /**
     * toString()方法重写时需要注意:
     * 不能直接输出wife,输出wife.getName(),
     * 要不然会出现递归导致的核内存溢出错误。
     * @return
     */
    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }
}
