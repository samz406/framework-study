package org.samz.resilience4j.demo;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.samz.resilience4j.exception.BusinessException;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

/**
 * @author: lilin
 * @Date: 2021/12/7 19:23
 * @Description:
 */
public class CircuitBreakerObj {


    public static CircuitBreaker getCircuitBreaker() {

        // Create a custom configuration for a CircuitBreaker
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .permittedNumberOfCallsInHalfOpenState(2)
                .slidingWindowSize(2)
                .recordExceptions(IOException.class, TimeoutException.class)
                .ignoreExceptions(BusinessException.class)
                .build();
        // Create a CircuitBreakerRegistry with a custom global configuration
        CircuitBreakerRegistry circuitBreakerRegistry =
                CircuitBreakerRegistry.of(circuitBreakerConfig);


        CircuitBreaker circuitBreaker = circuitBreakerRegistry
                .circuitBreaker("name");

        return circuitBreaker;
    }
}
