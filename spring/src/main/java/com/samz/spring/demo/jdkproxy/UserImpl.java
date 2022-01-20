package com.samz.spring.demo.jdkproxy;

/**
 * @author: lilin
 * @Date: 2022/1/20 16:50
 * @Description:
 */
public class UserImpl  implements IUser{
    @Override
    public String say(String name) {

        System.out.println("hello "+ name);
        return name;
    }
}
