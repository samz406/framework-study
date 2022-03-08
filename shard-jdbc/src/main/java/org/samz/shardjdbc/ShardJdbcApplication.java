package org.samz.shardjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.samz.shardjdbc.mapper")
@SpringBootApplication
public class ShardJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardJdbcApplication.class, args);
    }

}
