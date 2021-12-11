package org.samz.resilience4j.demo;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.vavr.CheckedRunnable;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: lilin
 * @Date: 2021/12/7 19:36
 * @Description:  https://reflectoring.io/rate-limiting-with-springboot-resilience4j/、
 *
 * https://resilience4j.readme.io/docs/ratelimiter
 */
@Slf4j
public class RateLimitDemo1 {

    public static void main(String[] args) {

        UserService userService = new UserService();

        final RateLimiter rateLimiter = RateLimitConf.getRateLimit();

        CheckedRunnable checkedRunnable = RateLimiter
                .decorateCheckedRunnable(rateLimiter, userService::getAge);

        Try.run(checkedRunnable).onFailure((RequestNotPermitted throwable)->{System.out.println("");});


    }
}
