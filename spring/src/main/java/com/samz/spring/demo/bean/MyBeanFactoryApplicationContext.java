package com.samz.spring.demo.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import com.samz.spring.demo.ApplicationDemo;

/**
 * @author: lilin
 * @Date: 2022/4/29 16:25
 * @Description:
 */

@ComponentScan(basePackages = "com.samz.spring.demo.bean")
@Configuration
public class MyBeanFactoryApplicationContext {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //如果没有 refresh 会error org.springframework.context.annotation.AnnotationConfigApplicationContext@6d9c638 has not been refreshed yet
        applicationContext.register(MyBeanFactoryApplicationContext.class);
        applicationContext.refresh();

        MyBeanFactory myBeanFactory = (MyBeanFactory) applicationContext.getBean("myBeanFactory");


        myBeanFactory.init();


    }

}
