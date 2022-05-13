package com.samz.spring.demo.advice;

import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MethodBeforDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.samz.spring.demo.advice");
        //register 目的是开启AspectJ 代理
        annotationConfigApplicationContext.register(MethodBeforDemo.class);
        annotationConfigApplicationContext.refresh();

        IUserService userService = annotationConfigApplicationContext.getBean("userService", IUserService.class);
        userService.getUsers();
    }


    @Bean
    public NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor(UserServiceAdvice userServiceAdvice) {
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setAdvice(userServiceAdvice);
        advisor.setMappedName("getUsers");
        return advisor;

    }


}
