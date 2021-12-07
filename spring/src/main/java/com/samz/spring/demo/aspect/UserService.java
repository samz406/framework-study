package com.samz.spring.demo.aspect;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void getUser(){

        System.out.printf("获取用户列表 \n");
    }
}
