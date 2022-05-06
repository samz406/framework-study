package com.samz.spring.demo.bean.set;

import org.springframework.stereotype.Service;

/**
 * @author: lilin
 * @Date: 2022/5/6 16:48
 * @Description:
 *
 * 构造方法添加参数，会报错。
 * Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException:
 * No qualifying bean of type 'java.lang.String' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
 *
 * 意思是只能注入一个bean对象的参数：No qualifying bean of type
 *
 */
@Service
public class ConstructBeanA {


    private String name;


    public ConstructBeanA(String name){

        this.name= name;
    }

}
