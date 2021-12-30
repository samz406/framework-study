package org.samz.resilience4j.retry;

import java.time.Duration;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;

/**
 * rety doc https://resilience4j.readme.io/docs/retry
 *
 * @author: lilin
 * @Date: 2021/12/30 19:16
 * @Description:
 */
public class Resilience4jRetry {

    private int count;

    private RetryConfig config = RetryConfig.custom()
            .maxAttempts(5)
            .waitDuration(Duration.ofMillis(100))
            .retryExceptions(Exception.class)
            .failAfterMaxAttempts(true)
            .build();

    public static void main(String[] args) {

        Resilience4jRetry resilience4jRetry = new Resilience4jRetry();
        int result = resilience4jRetry.get();
        System.out.println(result);
    }

    public int sayHello() {
        count++;
        System.out.println(count);

        return 2 / 0;
    }

    public int get() {

        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("name1");
        return Retry.decorateSupplier(retry, () -> sayHello()).get();

    }
}
