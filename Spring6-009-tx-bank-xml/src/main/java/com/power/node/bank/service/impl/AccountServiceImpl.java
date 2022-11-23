package com.power.node.bank.service.impl;

import com.power.node.bank.dao.AccountDao;
import com.power.node.bank.pojo.Account;
import com.power.node.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @Author darren
 * @Date 2022/11/16 10:03
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private static final int NUM = 2;

    @Autowired
    private AccountDao accountDao;


    /**
     * 控制事务
     * @param fromActno 转出账户
     * @param toActno 转入账户
     * @param money 转出金额
     */
    @Override
    public void transfer(final String fromActno, final String toActno, final double money) {
        Account fromAccount = accountDao.selectByActno(fromActno);

        if (fromAccount.getBalance() < money){
            throw new RuntimeException("余额不足");
        }
        Account toAccount = accountDao.selectByActno(toActno);

        fromAccount.setBalance(fromAccount.getBalance() - money);
        toAccount.setBalance(toAccount.getBalance() + money);

        int i = accountDao.updateByActno(fromAccount);
//        String s = null;
//        s.toString();
        i += accountDao.updateByActno(toAccount);
        if (i != NUM) {
            throw new RuntimeException("转账失败");
        }
    }


}
