package com.samz.spring.demo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import com.samz.spring.demo.bean.HelloService;

/**
 * @author: lilin
 * @Date: 2021/11/9 19:04
 * @Description: Enhancer cglib增强
 */
public class ProxyDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(HelloService.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {

            long start = System.currentTimeMillis();
            //调用代理的父类。
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("总耗时:" + (System.currentTimeMillis() - start));

            return result;
        });

        HelloService helloService = (HelloService) enhancer.create();
        System.out.println(helloService.sayHello());

    }
}
