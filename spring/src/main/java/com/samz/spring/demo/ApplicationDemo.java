package com.samz.spring.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lilin
 * @Date: 2021/11/8 19:19
 * @Description:
 */
public class ApplicationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationDemo.class);
    }
}
