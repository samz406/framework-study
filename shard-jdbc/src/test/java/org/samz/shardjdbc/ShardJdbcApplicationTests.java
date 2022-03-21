package org.samz.shardjdbc;

import javax.annotation.Resource;
import javax.naming.ldap.PagedResultsControl;

import org.junit.jupiter.api.Test;
import org.samz.shardjdbc.entity.Address;
import org.samz.shardjdbc.entity.Dict;
import org.samz.shardjdbc.entity.User;
import org.samz.shardjdbc.mapper.AddressMapper;
import org.samz.shardjdbc.mapper.DictMapper;
import org.samz.shardjdbc.mapper.UserMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardJdbcApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private DictMapper dictMapper;
    @Resource
    private AddressMapper addressMapper;
    @Test
     void contextLoads() {
    }

    @Test
    public void addUser(){

        for (int i = 0; i < 10; i++) {
            User user = new User();
           // user.setId(Long.valueOf(i));
            user.setAddress("1");
            user.setAge(20);
            user.setName("1");
            user.setPhone("1");
            userMapper.insert(user);
        }

    }

    @Test
    public void addDict(){

        for (int i = 0; i < 20; i++) {

            Dict dict = new Dict();
            dict.setCode("code"+i);
            dict.setValue("value"+i);
            dictMapper.insert(dict);
        }

    }

    @Test
    public void addAddress(){

        for (int i = 0; i < 10; i++) {

            Address address = new Address();
            address.setAddress("address "+ i);
            addressMapper.insert(address);
        }


    }

}
