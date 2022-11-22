package com.power.node.bank.service;

import com.power.node.bank.pojo.Account;

/**
 *
 * @Author darren
 * @Date 2022/11/16 10:02
 */
public interface AccountService {

    /**
     *
     * @param fromActno 转出账户
     * @param toActno 转入账户
     * @param money 转出金额
     */
    void transfer(String fromActno,String toActno,double money);

    int addAccount(Account account);
}
