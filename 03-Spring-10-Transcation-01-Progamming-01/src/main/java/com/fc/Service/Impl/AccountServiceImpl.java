package com.fc.Service.Impl;

import com.fc.Service.AccountService;
import com.fc.dao.AccountDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    //先声明一个事务管理模板
   private TransactionTemplate transactionTemplate;


    @Override
    public void transfer(Integer from, Integer to, Long money) {
        //创建一个事务模板
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.increaseMoney(to , money);
                    int i=1/0;
                accountDao.decreaseMoney(from,money);
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
