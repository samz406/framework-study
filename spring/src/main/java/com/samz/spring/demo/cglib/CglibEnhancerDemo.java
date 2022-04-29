package com.samz.spring.demo.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author: lilin
 * @Date: 2021/11/9 19:04
 * @Description: Enhancer cglib增强
 */
public class CglibEnhancerDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //非接口代理
        enhancer.setSuperclass(HelloServiceImpl.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            long start = System.currentTimeMillis();
            //调用代理的父类。
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("总耗时:" + (System.currentTimeMillis() - start));
            return result;
        });

        HelloServiceImpl helloService = (HelloServiceImpl) enhancer.create();
        helloService.say();

    }
}
