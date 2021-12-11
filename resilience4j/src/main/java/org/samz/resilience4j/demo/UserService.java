package org.samz.resilience4j.demo;

import org.springframework.stereotype.Service;

/**
 * @author: lilin
 * @Date: 2021/12/7 19:13
 * @Description:
 */
@Service
public class UserService {


    public String getUserName() {

        int i = 2 / 0;
        return "结果为" + i;
    }

    public String getUserName(Integer num) {

        int i = 2 / num;
        return "结果为" + i;
    }
}
