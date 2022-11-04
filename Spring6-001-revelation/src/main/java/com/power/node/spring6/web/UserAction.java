package com.power.node.spring6.web;

import com.power.node.spring6.service.UserService;
import com.power.node.spring6.service.impl.UserServiceImpl;

public class UserAction {
    private UserService userService = new UserServiceImpl();

    public void deleteById(){
        userService.deleteUser();
    }
}
