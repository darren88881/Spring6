package com.power.node.bank.service;

import com.power.node.bank.pojo.Account;

import java.util.List;

/**
 *
 * @Author darren
 * @Date 2022/11/23 16:15
 */
public interface AccountService {

    int insertAccount(Account account);
    int deleteAccountByActno(String actno);
    int updateAccount(Account account);
    Account selectAccountByActno(String actno);
    List<Account> selectAccountAll();
    void transfer(String fromActno, String toActno, Double money);
}
