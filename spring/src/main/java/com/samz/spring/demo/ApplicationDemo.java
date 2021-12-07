package com.samz.spring.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lilin
 * @Date: 2021/11/8 19:19
 * @Description:
 */
@Configuration
public class ApplicationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationDemo.class);

        //如果没有 refresh 会error org.springframework.context.annotation.AnnotationConfigApplicationContext@6d9c638 has not been refreshed yet
        applicationContext.refresh();
        User user = applicationContext.getBean(User.class);
        System.out.println(user == null);

    }

    @Bean
    public User newUser(){
        return  new User();
    }
}
