package org.samz.resilience4j.demo;

import org.apache.commons.logging.Log;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.vavr.CheckedRunnable;
import io.vavr.control.Try;
import lombok.extern.log4j.Log4j;
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

        final RateLimiter rateLimiter = RateLimitObj.getRateLimit();

        // Decorate your call to BackendService.doSomething()
        CheckedRunnable restrictedCall = RateLimiter
                .decorateCheckedRunnable(rateLimiter, userService::getUserName);

        Try.run(restrictedCall)
                .andThenTry(restrictedCall)
                .onFailure((RequestNotPermitted throwable) -> userService.getUserName());

    }
}
