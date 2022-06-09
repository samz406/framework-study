package com.samz.spring.demo.start;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class UserRole {

    @PostConstruct
    public void init(){

        System.out.println("UserRole init");
    }
}
