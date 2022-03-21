package com.samz.spring.demo;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.samz.spring.demo.bean.HelloService;
import com.samz.spring.demo.bean.ProxyInterceptor;
import com.samz.spring.demo.bean.UserService;

/**
 * @author: lilin
 * @Date: 2021/11/8 19:19
 * @Description:
 */
@ComponentScan(basePackages = "com.samz.spring.demo")
@Configuration
public class ApplicationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationDemo.class);

        //如果没有 refresh 会error org.springframework.context.annotation.AnnotationConfigApplicationContext@6d9c638 has not been refreshed yet
        applicationContext.refresh();
        UserService user = applicationContext.getBean(UserService.class);
        System.out.println(user == null);

    }

    @Bean
    public User newUser(){
        return  new User();
    }

}
