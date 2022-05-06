package com.samz.spring.demo.bean.set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lilin
 * @Date: 2022/5/6 16:47
 * @Description:
 */
@ComponentScan(basePackages = "com.samz.spring.demo.bean")
@Configuration
public class ConstructBeanAMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //如果没有 refresh 会error org.springframework.context.annotation.AnnotationConfigApplicationContext@6d9c638 has not been refreshed yet
        applicationContext.register(ConstructBeanAMain.class);
        applicationContext.refresh();


    }
}
