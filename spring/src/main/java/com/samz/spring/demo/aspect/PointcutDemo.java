package com.samz.spring.demo.aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 *Pointcut 测试。
 */
@EnableAspectJAutoProxy
public class PointcutDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

       annotationConfigApplicationContext.scan("com.samz.spring.demo.aspect");
       //register 目的是开启AspectJ 代理
        annotationConfigApplicationContext.register(PointcutDemo.class);
        annotationConfigApplicationContext.refresh();

        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
        userService.getUser();

    }
}
