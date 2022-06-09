package com.samz.spring.demo.start;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Init  implements InitializingBean
{
    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("init");
    }
}
