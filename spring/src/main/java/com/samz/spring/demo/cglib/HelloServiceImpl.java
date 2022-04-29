package com.samz.spring.demo.cglib;

/**
 * @author: lilin
 * @Date: 2022/4/29 17:15
 * @Description:
 */
public class HelloServiceImpl implements IHelloService{
    @Override
    public void say() {

        System.out.println("hello world");
    }
}
