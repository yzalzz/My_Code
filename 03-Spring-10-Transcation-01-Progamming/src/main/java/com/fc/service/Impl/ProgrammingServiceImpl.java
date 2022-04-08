package com.fc.service.Impl;

import com.fc.dao.AccountDao;
import com.fc.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class ProgrammingServiceImpl implements AccountService {
    //service层不能直接操作数据库
    private AccountDao accountDao;
    //要想用编程事务就必须声明一个事务模板
     private TransactionTemplate transactionTemplate;


    @Override
    public void transfer(Integer from, Integer to, Long money) {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.decreaseMoney(from , money);
//                int i=1/0;
                accountDao.increaseMoney(to, money);
            }
        });


    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
}


