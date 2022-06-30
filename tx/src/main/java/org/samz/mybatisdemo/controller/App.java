package org.samz.mybatisdemo.controller;

import javax.annotation.Resource;

import org.samz.mybatisdemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lilin
 * @Date: 2022/6/29 12:33
 * @Description:
 */
@RestController
public class App {

    @Resource
    private UserService userService;

    @GetMapping("init")
    public void init(){

        userService.say();

    }
}
