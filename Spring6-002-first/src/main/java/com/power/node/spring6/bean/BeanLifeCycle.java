package com.power.node.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

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
public class BeanLifeCycle implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware,
        ApplicationContextAware, InitializingBean, DisposableBean {

    private String name;

    public BeanLifeCycle() {
        System.out.println("第一步:实例化Bean");
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        System.out.println("第二步:给Bean属性赋值");
        this.name = name;
    }

    @Override
    public void setBeanName(final String s) {
        System.out.println("    第2.2步-属性感知-设置属性名称:"+s);
    }

    @Override
    public void setBeanClassLoader(final ClassLoader classLoader) {
        System.out.println("    第2.3步-属性感知-设置类加载器:"+classLoader);
    }

    @Override
    public void setBeanFactory(final BeanFactory beanFactory) throws BeansException {
        System.out.println("    第2.4步-属性感知-设置bean工厂:"+beanFactory);
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext)
            throws BeansException {
        System.out.println("    第2.5步-属性感知-设置上下文:"+applicationContext);
        System.out.println("");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("        第3.1.1步-初始化之前调用");
    }

    public void initMethod(){
        System.out.println("第三步:初始化Bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("    第5.1步-销毁-在destroy-method 之前调用");
    }

    public void destroyMethod(){
        System.out.println("第五步:销毁Bean ");
    }

    @Override
    public String toString() {
        return "BeanLifeCycle{" +
                "name='" + name + '\'' +
                '}';
    }
}
