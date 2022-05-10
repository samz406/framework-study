package com.samz.spring.demo.beanpostprocess;

import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: lilin
 * @Date: 2022/5/10 11:31
 * @Description:
 */
@Component
public class BeanPostProcessProx implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean.getClass() == BaseServiceImpl.class) {
            Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), (object, method, args) -> {
                System.out.println("method start");
                Object result = method.invoke(bean, args);
                System.out.println("method end");
                return result;
            });
            return proxy;
        }

        return bean;
    }
}
