package org.samz.jpa.controller;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

import javax.annotation.Resource;

import org.samz.jpa.repo.UserEntity;
import org.samz.jpa.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lilin
 * @Date: 2022/1/20 10:46
 * @Description:
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("add")
    public void save() {

        UserEntity userEntity = new UserEntity();
        String name = "三木子" + RandomStringUtils.random(3);
        userEntity.setUserName(name);
        userEntity.setAge(new Random().nextInt(70));
        userEntity.setAddress(RandomStringUtils.randomAlphanumeric(5));
        userService.save(userEntity);

    }
}
