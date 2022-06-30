package org.samz.mybatisdemo.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.samz.mybatisdemo.config.DataSourceHolder;
import org.springframework.stereotype.Component;

/**
 * @author: lilin
 * @Date: 2022/6/28 16:52
 * @Description:
 */
@Component
@Aspect
public class DSAspect {


    @Pointcut("@annotation(org.samz.mybatisdemo.aop.DS)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 方法上注解
        DS methodAnno = method.getAnnotation(DS.class);

        final String key = methodAnno.value();
        DataSourceHolder.set(key);

        try {
            final Object proceed = proceedingJoinPoint.proceed();
            return proceed;
        }finally {
            DataSourceHolder.remove();
        }

    }
}
