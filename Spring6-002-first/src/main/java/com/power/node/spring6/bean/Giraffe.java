package com.power.node.spring6.bean;

import java.util.Date;

/**
 * 长颈鹿
 * @Author darren
 * @Date 2022/11/2 8:44
 */
public class Giraffe {
    private Date birth;

    public Date getBirth() {
        return birth;
    }

    public void setBirth(final Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Giraffe{" +
                "birth=" + birth +
                '}';
    }
}
