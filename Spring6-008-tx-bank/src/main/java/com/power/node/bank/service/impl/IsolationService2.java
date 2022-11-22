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

    /**
     * timeout 如果该事务中所有的DML语句还没有执行完毕的话，最终结果会选择回滚。
     * @param account
     */
    @Transactional(rollbackFor = Exception.class, timeout = 10)
    public void insertAccount(Account account){
        mAccountDao.insetActno(account);

        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
