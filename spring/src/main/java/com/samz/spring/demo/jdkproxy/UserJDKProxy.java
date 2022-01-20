package com.samz.spring.demo.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: lilin
 * @Date: 2022/1/20 16:48
 * @Description:
 */
public class UserJDKProxy {


    public static void main(String[] args) {


        UserImpl user = new UserImpl();

        final IUser instance = (IUser) Proxy.newProxyInstance(UserJDKProxy.class.getClassLoader(), new Class[]{IUser.class}, (proxy, method, args1) -> {

            System.out.println("invoke start");
            return method.invoke(user, args1);
        });

        instance.say("samz");

    }
}
