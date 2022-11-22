package com.power.node.bank.service.impl;

import com.power.node.bank.dao.AccountDao;
import com.power.node.bank.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @Author darren
 * @Date 2022/11/22 17:10
 */
@Service("iso2")
public class IsolationService2 {

    @Autowired
    private AccountDao mAccountDao;

    @Transactional(rollbackFor = Exception.class)
    public void insertAccount(Account account){
        mAccountDao.insetActno(account);

        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
