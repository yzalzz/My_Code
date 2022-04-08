package com.fc.test;

import com.fc.Service.AccountService;
import com.fc.Service.Impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService bean = applicationContext.getBean(AccountServiceImpl.class);

        bean.transfer(1,2,200L);

    }
}
