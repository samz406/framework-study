package com.samz.spring.demo.bean;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("method start");
        Object proceed = invocation.proceed();

        System.out.println("method end");
        return proceed;
    }
}
