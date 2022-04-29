package com.samz.spring.demo.bean;

import javax.annotation.PostConstruct;

/**
 * @author: lilin
 * @Date: 2022/4/29 16:24
 * @Description:
 */
public class MyBeanFactory {

    @PostConstruct
    public void init(){
        System.out.println("MyBeanFactory init");
    }
}
