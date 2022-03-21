package com.samz.spring.demo.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @author: lilin
 * @Date: 2021/11/8 19:23
 * @Description:
 */
@Service
public class UserService {

    @Resource
    private RoleService roleService;
}
