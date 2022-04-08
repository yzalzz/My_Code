package com.fc.dao.Impl;

import com.fc.dao.AccountDao;
import com.fc.entity.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void increaseMoney(Integer id, Long money) {

        getJdbcTemplate().update("update account set money = money + ? where id =?",money,id);

        System.out.println("充值成功");
    }

    @Override
    public void decreaseMoney(Integer id, Long money) {

        getJdbcTemplate().update("update account set money =money - ? where id =?",money,id);

        System.out.println("扣费成功");
    }
}