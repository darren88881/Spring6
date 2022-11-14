package com.power.node.spring6.bank;

import org.springframework.stereotype.Service;

/**
 * 银行业务层
 * @Author darren
 * @Date 2022/11/14 10:10
 */
@Service
public class BankService {

    public void getMoney(){
        System.out.println("正在去取钱。。。。");
    }
}
