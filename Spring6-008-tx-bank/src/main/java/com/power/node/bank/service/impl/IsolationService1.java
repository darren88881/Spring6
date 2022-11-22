package com.power.node.bank.service.impl;

import com.power.node.bank.dao.AccountDao;
import com.power.node.bank.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @Author darren
 * @Date 2022/11/22 17:09
 */
@Service("iso1")
public class IsolationService1 {

    @Autowired
    private AccountDao mAccountDao;

    /**
     * 事务的隔离级别
     *  DEFAULT             默认的
     *  READ_UNCOMMITTED    读取未提交
     *  READ_COMMITTED      读取已提交
     *  REPEATABLE_READ     可重复都
     *  SERIALIZABLE        串行化
     *
     * @param actno
     * @return
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
    public Account getAccountByActno(String actno){
        return mAccountDao.selectByActno(actno);
    }
}
