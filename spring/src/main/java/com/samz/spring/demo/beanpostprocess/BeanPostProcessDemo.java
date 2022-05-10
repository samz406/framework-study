package com.samz.spring.demo.beanpostprocess;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.samz.spring.demo.aspect.PointcutDemo;
import com.samz.spring.demo.aspect.UserService;

/**
 * @author: lilin
 * @Date: 2022/5/10 11:22
 * @Description:
 */
@Configuration
public class BeanPostProcessDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.samz.spring.demo.beanpostprocess");
        //register 目的是开启AspectJ 代理
        annotationConfigApplicationContext.register(BeanPostProcessDemo.class);
        annotationConfigApplicationContext.refresh();


        //BaseServiceImpl 改为了proxy。这里需要只能通过bean 名称获取
        IBaseService userService = (IBaseService)annotationConfigApplicationContext.getBean("baseServiceImpl");
        userService.say();
        //同类中调用一个代理的方法。
        //userService.getInfo();
    }
}
