package com.power.node.bank.service.impl;

import com.power.node.bank.dao.AccountDao;
import com.power.node.bank.pojo.Account;
import com.power.node.bank.service.AccountService;
import com.power.node.bank.service.InsetAccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource(name ="insetAccountService")
    private InsetAccountService insetAccountService;


    /**
     * 控制事务
     * @param fromActno 转出账户
     * @param toActno 转入账户
     * @param money 转出金额
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transfer(final String fromActno, final String toActno, final double money) {
        Account fromAccount = accountDao.selectByActno(fromActno);

        if (fromAccount.getBalance() < money){
            throw new RuntimeException("余额不足");
        }
        Account toAccount = accountDao.selectByActno(toActno);

        fromAccount.setBalance(fromAccount.getBalance() - money);
        toAccount.setBalance(toAccount.getBalance() + money);

        int i = accountDao.updateByActno(fromAccount);
        i += accountDao.updateByActno(toAccount);
        if (i != NUM) {
            throw new RuntimeException("转账失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int addAccount(final Account account) {
        int num1 = accountDao.insetActno(account);

        int num2 = insetAccountService.insetAccount(new Account("ACT-004", 1000.00));
        return num1+num2;
    }

}
