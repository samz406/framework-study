package com.samz.spring.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * 代码是实现通知
 */
public class AspectDemo {


    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(map);
        aspectJProxyFactory.addAdvice((MethodBeforeAdvice) (method, args1, target) -> {
            if ("get".equals(method.getName())) {
                System.out.println("有人要开始获取值");
            }
        });

        Map<String, String> proxyMap = aspectJProxyFactory.getProxy();
        proxyMap.put("1", "2");
        System.out.printf(proxyMap.get("1"));
    }
}
