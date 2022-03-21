package org.samz.resilience4j.controller;

import javax.annotation.Resource;

import org.samz.resilience4j.demo.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

    @Resource
    private UserService service;

    @GetMapping("user")
    public String getUser(Integer num) {
        System.out.println("1111111");
        return service.getUserName(num);
    }

    @GetMapping("user/2")
    @CircuitBreaker(name = "user", fallbackMethod = "fallback")
    public String getUser1(Integer num) {
        return service.getUserName(num);
    }


    public String fallback(Throwable th) {
        log.error("开始熔断", th.getMessage());
        return "请求异常";
    }

    @GetMapping("user/bulkhead")
    @Bulkhead(name = "user", fallbackMethod = "bulkheadFallback")
    public String getUserBulkhead() {
        return "你的年龄是:" + service.getAge();
    }

    public String bulkheadFallback(BulkheadFullException exception) {
        log.error("服务调用失败", exception.getMessage());
        return "返回bulkhead";
    }


}
