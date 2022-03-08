package com.samz.spring.demo.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.samz.spring.demo.User;

@Service
public class RoleService {
    @Resource
    private UserService userService;
}
