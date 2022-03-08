package com.samz.spring.demo.bean;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.samz.spring.demo.ApplicationDemo;

public class ProxyMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationDemo.class);

        //如果没有 refresh 会error org.springframework.context.annotation.AnnotationConfigApplicationContext@6d9c638 has not been refreshed yet
        applicationContext.refresh();
        HelloService helloService = applicationContext.getBean(HelloService.class);
        helloService.sayHello();

    }

    @Bean
    public ProxyFactoryBean createProxyFactory() throws ClassNotFoundException {

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setProxyInterfaces(new Class[] {ProxyInterceptor.class});
       // proxyFactoryBean.setTarget(helloService);

        return proxyFactoryBean;
    }

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
