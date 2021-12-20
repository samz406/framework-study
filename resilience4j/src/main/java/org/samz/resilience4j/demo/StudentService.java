package org.samz.resilience4j.demo;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

/**
 * @author: lilin
 * @Date: 2021/12/20 16:26
 * @Description:
 */
public interface StudentService {

    @Retryable(value = RuntimeException.class)
    String getUser(Integer id);

    @Recover
    String recover(RuntimeException r, Integer id, String result);
}
