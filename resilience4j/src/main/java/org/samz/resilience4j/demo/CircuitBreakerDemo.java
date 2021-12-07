package org.samz.resilience4j.demo;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

import org.samz.resilience4j.exception.BusinessException;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.control.Try;

/**
 * @author: lilin
 * @Date: 2021/12/7 19:10
 * @Description:
 */
public class CircuitBreakerDemo {

    public static void main(String[] args) {

        UserService userService = new UserService();

        //包装方法
        Supplier<String> decoratedSupplier = CircuitBreaker
                .decorateSupplier(CircuitBreakerObj.getCircuitBreaker(), userService::getUserName);

        String result = Try.ofSupplier(decoratedSupplier)
                .recover(throwable -> "Hello from Recovery").get();

        System.out.println(result);

    }
}
