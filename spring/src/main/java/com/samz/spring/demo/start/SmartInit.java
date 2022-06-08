package com.samz.spring.demo.start;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

@Component
public class SmartInit implements SmartInitializingSingleton {

    @Override
    public void afterSingletonsInstantiated() {

        System.out.println("SmartInit");
    }
}
