package com.power.node.spring6.bean;

/**
 * Bean的生命周期按照粗略的五步的话:
 * 第一步:实例化Bean(调用无参数构造方法。)
 * 第二步:给Bean属性赋值(调用set方法。)
 * 第三步:初始化Bean (会调用Bean的init方法。注意:这个init方法需要自己写,自己配。)
 * 第四步:使用Bean
 * 第五步:销毁Bean (公调用Bean/destroy方法。注意:这个destroy方法需要自己写,自己配。)
 * @Author darren
 * @Date 2022/11/2 9:25
 */
public class BeanLifeCycle {
    private String beanName;

    public BeanLifeCycle() {
        System.out.println("第一步:实例化Bean");
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(final String beanName) {
        System.out.println("第二步:给Bean属性赋值");
        this.beanName = beanName;
    }

    public void initMethod(){
        System.out.println("第三步:初始化Bean");
    }

    public void destroyMethod(){
        System.out.println("第五步:销毁Bean ");
    }

    @Override
    public String toString() {
        return "BeanLifeCycle{" +
                "beanName='" + beanName + '\'' +
                '}';
    }
}
