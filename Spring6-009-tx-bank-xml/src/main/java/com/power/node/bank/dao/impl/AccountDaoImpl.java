package com.power.node.bank.dao.impl;

import com.power.node.bank.dao.AccountDao;
import com.power.node.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @Author darren
 * @Date 2022/11/16 9:39
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(final String actno) {
        String sql = "select actno, balance from t_act where actno = ?";
        Account account = jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Account.class), actno);
        return account;
    }

    @Override
    public int updateByActno(Account account) {
        String sql = "update t_act set balance = ? where actno = ?";
        int count = jdbcTemplate.update(sql, account.getBalance(), account.getActno());
        return count;
    }

    @Override
    public int insetActno(final Account account) {
        String sql = "insert into t_act values (?,?)";
        int update = jdbcTemplate.update(sql, account.getActno(), account.getBalance());
        return update;
    }
}
