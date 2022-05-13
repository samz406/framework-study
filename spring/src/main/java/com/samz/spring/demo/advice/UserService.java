package com.samz.spring.demo.advice;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{


    @Override
    public void getUsers(){

        System.out.println("get user");
    }

}
