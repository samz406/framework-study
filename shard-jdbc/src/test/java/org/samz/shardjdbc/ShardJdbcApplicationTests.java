package org.samz.shardjdbc;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.samz.shardjdbc.entity.User;
import org.samz.shardjdbc.mapper.UserMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardJdbcApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
     void contextLoads() {
    }

    @Test
    public void addUser(){

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAddress("1");
            user.setAge(20);
            user.setName("1");
            user.setPhone("1");
            userMapper.insert(user);
        }

    }

}
