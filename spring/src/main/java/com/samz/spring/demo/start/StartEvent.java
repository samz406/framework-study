package com.samz.spring.demo.start;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * ApplicatonContext 实例化完成
 */
@Component
public class StartEvent implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        System.out.println("StartEvent");
    }
}
