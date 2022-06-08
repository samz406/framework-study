package com.samz.spring.demo.aware;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

@Service
public class User  implements BeanNameAware, BeanFactoryAware , BeanPostProcessor, InitializingBean {


    @PostConstruct
    public void init(){
        System.out.println("init");
    }
    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        System.out.println("beanFactory");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {


        System.out.println("postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
