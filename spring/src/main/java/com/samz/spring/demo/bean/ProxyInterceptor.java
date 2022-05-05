package com.samz.spring.demo.bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ProxyInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("method start");
        Object proceed = invocation.proceed();

        System.out.println("method end");
        return proceed;
    }
}
