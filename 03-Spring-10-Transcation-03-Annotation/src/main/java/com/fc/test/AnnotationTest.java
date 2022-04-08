package com.fc.test;

import com.fc.config.TxtConfig;
import com.fc.service.AnnotationService;
import com.fc.service.Impl.AnnotationServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    @Test
    public void testAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxtConfig.class);

        AnnotationService service = applicationContext.getBean("annotationServiceImpl",AnnotationService.class);

        service.transfer(1, 2, 500L);
    }
    @Test
    public void test(){
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AnnotationService bean = applicationContext.getBean(AnnotationService.class);

        bean.transfer(1,2,200L);

    }
}
