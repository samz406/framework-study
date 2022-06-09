package com.samz.spring.demo.aspect;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    //注入是的代理对象实例。
    @Resource
    private UserService userService;

    public void getUser() {

        int i = 2/0;
        System.out.printf("获取用户列表 \n");
    }

    public void getInfo() {
        
        //1 在代理类调用同样被代理的方法，不能用this。需要再依赖注入一个代理类。
        userService.getUser();
        //下面调用是无效的,this指向的不是UserService对象，不是aop代理对象，
        // this.getUser();
        //2 从AopContext 获取当前的 Proxy。需要在@EnableAspectJAutoProxy添加属性 exposeProxy = true


    }
}
