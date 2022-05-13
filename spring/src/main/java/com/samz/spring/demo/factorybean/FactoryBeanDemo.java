package com.samz.spring.demo.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lilin
 * @Date: 2022/5/13 17:07
 * @Description:
 */
@Configuration
public class FactoryBeanDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.samz.spring.demo.factorybean");
        //register 目的是开启AspectJ 代理
        annotationConfigApplicationContext.register(FactoryBeanDemo.class);
        annotationConfigApplicationContext.refresh();

        //获取factoryBean 创建的对象user
        Object user = annotationConfigApplicationContext.getBean("userFactoryBean");
        System.out.println(user.getClass());
        //获取factoryBean 本身对象,也就是加了一个前缀$
        Object userFactoryBean = annotationConfigApplicationContext.getBean("&userFactoryBean");

        System.out.println(userFactoryBean.getClass());


        //同类中调用一个代理的方法。
        //userService.getInfo();

    }


}
