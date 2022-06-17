package com.samz.spring.demo.beanpostprocess;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author: lilin
 * @Date: 2022/5/10 11:25
 * @Description:
 */
@Service
public class BaseServiceImpl implements IBaseService{

    @Resource
    private ApplicationContext applicationContext;
    @Override
    public void say() {

        System.out.println(applicationContext);
        System.out.println("hello world");
    }
}
