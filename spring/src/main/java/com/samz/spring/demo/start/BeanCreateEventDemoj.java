package com.samz.spring.demo.start;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.samz.spring.demo.aspect.PointcutDemo;
import com.samz.spring.demo.aspect.UserService;

public class BeanCreateEventDemoj {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.samz.spring.demo.start");
        //register 目的是开启AspectJ 代理
        annotationConfigApplicationContext.register(BeanCreateEventDemoj.class);
        annotationConfigApplicationContext.refresh();

    }
}
