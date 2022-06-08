package com.samz.spring.demo.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.samz.spring.demo.start.BeanCreateEventDemoj;

public class AwareDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.samz.spring.demo.aware");
        //register 目的是开启AspectJ 代理
        annotationConfigApplicationContext.register(AwareDemo.class);
        annotationConfigApplicationContext.refresh();


    }
}
