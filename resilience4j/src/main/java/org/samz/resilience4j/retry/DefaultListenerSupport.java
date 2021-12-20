package org.samz.resilience4j.retry;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: lilin
 * @Date: 2021/12/20 17:05
 * @Description:
 */
@Slf4j
public class DefaultListenerSupport implements RetryListener {


    @Override
    public <T, E extends Throwable> boolean open(RetryContext retryContext, RetryCallback<T, E> retryCallback) {
        return true;
    }

    @Override
    public <T, E extends Throwable> void close(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {

        log.error("DefaultListenerSupport close，retry {} times, message :", retryContext.getRetryCount());
    }
    @Override
    public <T, E extends Throwable> void onError(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {

        log.error("DefaultListenerSupport onError，retry {} times", retryContext.getRetryCount(), throwable);
    }
}
