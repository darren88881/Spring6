package com.power.node.bank.mapper;

import com.power.node.bank.pojo.Account;

import java.util.List;

/**
 * mapper 映射
 * @Author darren
 * @Date 2022/11/23 11:52
 */
public interface AccountMapper {
    int insertAccount(Account account);
    int deleteAccountByActno(String actno);
    int updateAccount(Account account);
    Account selectAccountByActno(String actno);
    List<Account> selectAccountAll();
}
