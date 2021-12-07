package org.samz.resilience4j.demo;

import java.time.Duration;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;

/**
 * @author: lilin
 * @Date: 2021/12/7 19:34
 * @Description:
 */
public class RateLimitObj {

    public static RateLimiter getRateLimit() {

        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofMillis(1))
                .limitForPeriod(10)
                .timeoutDuration(Duration.ofMillis(25))
                .build();

        // Create registry
        RateLimiterRegistry rateLimiterRegistry = RateLimiterRegistry.of(config);

        // Use registry
        RateLimiter rateLimiterWithDefaultConfig = rateLimiterRegistry
                .rateLimiter("name1");



        RateLimiter rateLimiterWithCustomConfig = rateLimiterRegistry
                .rateLimiter("name2", config);

        return rateLimiterWithCustomConfig;

    }
}
