package com.fc.test;

import com.fc.service.Impl.StatementServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountXMLTest {
    @Test
    public void  test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        StatementServiceImpl bean = applicationContext.getBean(StatementServiceImpl.class);

        bean.transfer(1,2,200L);
    }
}
