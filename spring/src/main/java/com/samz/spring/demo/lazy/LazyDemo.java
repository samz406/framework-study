package com.samz.spring.demo.lazy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class LazyDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.samz.spring.demo.lazy");
        //register 目的是开启AspectJ 代理
        annotationConfigApplicationContext.register(LazyDemo.class);
        annotationConfigApplicationContext.refresh();

        //延迟加载，在使用时bean再初始化；
        annotationConfigApplicationContext.getBean("userService");
    }

    /**
     * 启动时没有被初始化
     */
    @Lazy
    @Bean
    public UserService userService() {

        System.out.println("userService");
        return new UserService();
    }

    /**
     * 启动时初始化
     */
    @Bean
    @Qualifier("helloService")
    public UserService helloService() {

        System.out.println("hl");
        return new UserService();
    }
}


