package com.samz.spring.demo.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean 的生命周期
 */
public class AwareDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.samz.spring.demo.lifecycle");
        //register 目的是开启AspectJ 代理
        annotationConfigApplicationContext.register(AwareDemo.class);
        annotationConfigApplicationContext.refresh();


    }
}
