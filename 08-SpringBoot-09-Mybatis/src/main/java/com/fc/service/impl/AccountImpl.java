package com.fc.service.impl;

import com.fc.dao.AccountDao;
import com.fc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service

public class AccountImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED,
    readOnly = false) //此注解开启事务；(也可以在启动类上加@EnableTransactionManagement注解开启平台事务管理器，不加也行)
    public void transfer(Integer from, Integer to, Integer money) {
        accountDao.decrease(from,money);
        //如果不加事务 发生异常时只会执行，accountDao.decrease(from,money)而不会执行，accountDao.increase(to,money);
        int i=(1/0);
        accountDao.increase(to,money);
    }
}
