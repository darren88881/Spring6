package com.power.node.bank.dao;

import com.power.node.bank.pojo.Account;

/**
 *
 * @Author darren
 * @Date 2022/11/16 9:39
 */
public interface AccountDao {

    /**
     * 根据账号查询信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);


    /**
     * 修改账户信息
     * @param account
     * @return
     */
    int updateByActno(Account account);

    /**
     * 插入数据
     * @param account
     * @return
     */
    int insetActno(Account account);
}
