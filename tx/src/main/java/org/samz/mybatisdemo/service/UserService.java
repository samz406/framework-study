package org.samz.mybatisdemo.service;

import org.samz.mybatisdemo.aop.DS;
import org.springframework.stereotype.Service;

/**
 * @author: lilin
 * @Date: 2022/6/28 16:49
 * @Description:
 */
@Service
public class UserService {

    @DS("ds2")
    public void say(){

        System.out.println("hello world");
    }
}
