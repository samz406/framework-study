package org.samz.resilience4j.controller;

import javax.annotation.Resource;

import org.samz.resilience4j.demo.StudentService;
import org.samz.resilience4j.demo.StudentServiceImpl;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lilin
 * @Date: 2021/12/20 16:13
 * @Description:
 */
@RestController
public class RetryController {

    @Resource
    StudentService service;
    @Resource
    private RetryTemplate retryTemplate;

    @GetMapping("retry")
    public String test(Integer id) {

        return retryTemplate.execute((p)->service.getUser(id));
    }
}
