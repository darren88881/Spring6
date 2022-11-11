package com.power.node.spring6.service;

import org.springframework.stereotype.Service;

/**
 * 目标类
 * @Author darren
 * @Date 2022/11/11 9:51
 */
@Service
public class UserService {

    /**
     * 连接点1
     */
    public void loggin(){
        System.out.println("系统登录");
    }
    /**
     * 连接点2
     */
    public void logOut(){
        System.out.println("系统登录");
    }

}
