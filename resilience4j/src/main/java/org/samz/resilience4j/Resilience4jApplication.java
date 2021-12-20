package org.samz.resilience4j;

import org.samz.resilience4j.retry.DefaultListenerSupport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
@EnableRetry
@SpringBootApplication
public class Resilience4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Resilience4jApplication.class, args);
    }

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(500L);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(6);
        retryTemplate.setRetryPolicy(retryPolicy);
        retryTemplate.setThrowLastExceptionOnExhausted(true);
        retryTemplate.registerListener(new DefaultListenerSupport());

        return retryTemplate;
    }

}
