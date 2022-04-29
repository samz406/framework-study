package com.samz.spring.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author: lilin
 * @Date: 2022/4/29 16:21
 * @Description:
 */
@Component
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        beanFactory.registerSingleton("myBeanFactory",new MyBeanFactory());
        if (beanFactory instanceof BeanDefinitionRegistry){
            BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) beanFactory;
            BeanDefinition beanDefinition = new GenericBeanDefinition();
             beanDefinition.setBeanClassName(MyBeanFactory.class.getName());
            beanDefinitionRegistry.registerBeanDefinition("myBeanFactory2",beanDefinition);
        }
    }
}
