package com.samz.spring.demo.advice;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

@Component
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {


    @Resource
    private MethodBeforeAdvice methodBeforeAdvice;


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        methodBeforeAdvice.before(method,objects,o);
        return methodProxy.invoke(o,objects);
    }
}
