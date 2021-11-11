package com.samz.spring.demo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;

@Component
@Aspect
public class UserAspect {

    /**
     * Pointcut 配置，注入的入口
     */
    @Pointcut("execution(public * *(..))")
    public void pointcut(){

        System.out.println("Pointcut method");
    }

    /**
     * 方法调用前置入
     */
    @Before("pointcut()")
    public void method2(){
        System.out.println("Before method2");
    }

    /**
     * Around 要手动通过proceedingJoinPoint的方法proceed调用一次。
     * @param proceedingJoinPoint
     */
    @SneakyThrows
    @Around("pointcut()")
    public void method3(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Around before");
        proceedingJoinPoint.proceed();
        System.out.println("Around after");
    }

    /**
     * 方法调用后置入
     */
    @After("pointcut()")
    public void method4(){
        System.out.println("After method4");
    }


}
