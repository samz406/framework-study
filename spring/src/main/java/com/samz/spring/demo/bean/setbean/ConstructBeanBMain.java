package com.samz.spring.demo.bean.setbean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.samz.spring.demo.bean.set.ConstructBeanAMain;

/**
 * @author: lilin
 * @Date: 2022/5/6 17:05
 * @Description:
 */
@ComponentScan(basePackages = "com.samz.spring.demo.bean.setbean")
@Configuration
public class ConstructBeanBMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //如果没有 refresh 会error org.springframework.context.annotation.AnnotationConfigApplicationContext@6d9c638 has not been refreshed yet
        applicationContext.register(ConstructBeanBMain.class);
        applicationContext.refresh();


    }
}
