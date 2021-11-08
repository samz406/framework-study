package com.samz.spring.demo;

import java.lang.reflect.Method;

import org.springframework.util.ReflectionUtils;

/**
 * @author: lilin
 * @Date: 2021/11/8 19:03
 * @Description:
 */
public class UserTest {

    public static void main(String[] args) {

        final Method[] allDeclaredMethods = ReflectionUtils.getDeclaredMethods(User.class);

        for (Method allDeclaredMethod : allDeclaredMethods) {
            System.out.println(allDeclaredMethod.getName());
        }
    }
}
