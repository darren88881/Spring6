package com.powernode.spring6.bean;

/**
 * P命名空间和C命名空间注入
 *
 * @Author darren
 * @Date 2022/10/28 16:50
 */
public class Dog {

    private String name;
    private Integer age;

    public Dog() {
    }

    public Dog(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
