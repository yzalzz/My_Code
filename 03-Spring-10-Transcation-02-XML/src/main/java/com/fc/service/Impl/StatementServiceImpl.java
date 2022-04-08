package com.fc.service.Impl;

import com.fc.dao.AccountDao;
import com.fc.service.AccountService;

public class StatementServiceImpl implements AccountService {
    //service层不能直接调用数据库
    private AccountDao accountDao;

    @Override
    public void transfer(Integer from, Integer to, Long money) {
        accountDao.decreaseMoney(from,money);

        int i=1/0;

        accountDao.increaseMoney(to,money);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
