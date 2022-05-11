package org.samz.mybatisdemo.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lilin
 * @Date: 2022/5/11 11:03
 * @Description:
 */

@SpringBootApplication
@MapperScan("org.samz.mybatisdemo.mapper")
public class MybatisDemo {


    public static void main(String[] args) {

        SpringApplication.run(MybatisDemo.class, args);

    }
}
