package com.samz.spring.demo.beanpostprocess;

import org.springframework.stereotype.Service;

/**
 * @author: lilin
 * @Date: 2022/5/10 11:25
 * @Description:
 */
@Service
public class BaseServiceImpl implements IBaseService{
    @Override
    public void say() {

        System.out.println("hello world");
    }
}
