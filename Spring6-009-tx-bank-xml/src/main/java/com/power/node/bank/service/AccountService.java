package com.power.node.bank.service;

/**
 *
 * @Author darren
 * @Date 2022/11/16 10:02
 */
public interface AccountService {

    /**
     * 转账业务
     * @param fromActno 转出账户
     * @param toActno 转入账户
     * @param money 转出金额
     */
    void transfer(String fromActno,String toActno,double money);

}
