package com.power.node.bank.service.impl;

import com.power.node.bank.dao.AccountDao;
import com.power.node.bank.pojo.Account;
import com.power.node.bank.service.InsetAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @Author darren
 * @Date 2022/11/22 15:37
 */
@Service("insetAccountService")
public class InsetAccountServiceImpl implements InsetAccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int insetAccount(final Account account) {
        int i = accountDao.insetActno(account);
        return i;
    }
}
