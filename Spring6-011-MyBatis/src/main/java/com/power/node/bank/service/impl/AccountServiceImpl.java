package com.power.node.bank.service.impl;

import com.power.node.bank.mapper.AccountMapper;
import com.power.node.bank.pojo.Account;
import com.power.node.bank.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @Author darren
 * @Date 2022/11/23 16:17
 */
public class AccountServiceImpl implements AccountService {

    private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    private static final int NUM = 2;

    @Autowired
    private AccountMapper mAccountMapper;

    /**
     * 开户
     * @param account
     * @return
     */
    @Override
    public int insertAccount(final Account account) {
        return mAccountMapper.insertAccount(account);
    }

    /**
     * 销户
     * @param actno
     * @return
     */
    @Override
    public int deleteAccountByActno(final String actno) {
        return mAccountMapper.deleteAccountByActno(actno);
    }

    /**
     * 修改
     * @param account
     * @return
     */
    @Override
    public int updateAccount(final Account account) {
        return mAccountMapper.updateAccount(account);
    }

    /**
     * 查询账户
     * @param actno
     * @return
     */
    @Override
    public Account selectAccountByActno(final String actno) {
        return mAccountMapper.selectAccountByActno(actno);
    }

    /**
     * 查询所有账户
     * @return
     */
    @Override
    public List<Account> selectAccountAll() {
        return mAccountMapper.selectAccountAll();
    }

    /**
     * 转账
     * @param fromActno
     * @param ToActno
     * @param money
     */
    @Override
    public void transfer(final String fromActno, final String toActno, final Double money) {
        Account fromAccount = mAccountMapper.selectAccountByActno(fromActno);
        if (fromAccount.getBalance() > money) {
            logger.info("余额充足，可以转账");
            Account toAccount = mAccountMapper.selectAccountByActno(toActno);

            fromAccount.setBalance(fromAccount.getBalance() - money);
            toAccount.setBalance(toAccount.getBalance() + money);

            int count = mAccountMapper.updateAccount(fromAccount);
            count += mAccountMapper.updateAccount(toAccount);
            if (count != NUM) {
                logger.error("转账失败");
            }

        } else {
            logger.info("余额不足请充值后再转账");
        }
    }
}
