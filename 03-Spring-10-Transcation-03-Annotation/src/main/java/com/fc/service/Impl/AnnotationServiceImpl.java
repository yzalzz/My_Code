package com.fc.service.Impl;

import com.fc.dao.AccountDao;
import com.fc.service.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AnnotationServiceImpl implements AnnotationService {
    @Autowired
    private AccountDao accountDao;
    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED ,readOnly = false)
    public void transfer(Integer from, Integer to, Long money) {
        accountDao.increaseMoney(to , money);

        int i=1/0;

        accountDao.decreaseMoney(from ,money);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
