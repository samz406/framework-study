package org.samz.resilience4j.controller;

import javax.annotation.Resource;

import org.samz.resilience4j.demo.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

    @Resource
    private UserService service;

    @GetMapping("user")
    public String getUser(Integer num) {
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

}
