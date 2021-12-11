package org.samz.resilience4j.demo;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
//@Component
public class BreakerAspect {

    private static final Integer THRESHOLD = 3;

    private Map<String, AtomicInteger> counter = new HashMap<>();

    //熔断N次后尝试去重新请求下服务。
    private Map<String, AtomicInteger> breakcounter = new HashMap<>();

    @Around("execution(* org.samz.resilience4j.demo..*(..))")
    public Object doWithCircuitBreaker(ProceedingJoinPoint joinPoint) throws Throwable {

        String name = joinPoint.getSignature().toShortString();

        Object result;
        try {
            if (counter.containsKey(name)) {
                if (counter.get(name).get() > THRESHOLD && breakcounter.get(name).get() < THRESHOLD) {
                    breakcounter.get(name).incrementAndGet();
                    return "熔断返回参数";
                }
            } else {
                counter.put(name, new AtomicInteger(0));
                breakcounter.put(name, new AtomicInteger(0));
            }
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.warn("Circuit breaker counter {}", counter.get(name).incrementAndGet());
            breakcounter.get(name).set(0);
            throw throwable;
        }
        return result;
    }

}
