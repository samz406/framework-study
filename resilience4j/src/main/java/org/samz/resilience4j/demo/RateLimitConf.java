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
public class RateLimitConf {

    public static RateLimiter getRateLimit() {

        //limitRefreshPeriod 权限刷新的时间，每个周期结束后，RateLimiter将会把权限计数设置为limitForPeriod的值
        //timeoutDuration 线程等待权限的默认等待时间
        //limitForPeriod 一个限制刷新期间的可用权限数
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
                .rateLimiter("user", config);

        return rateLimiterWithCustomConfig;

    }
}
