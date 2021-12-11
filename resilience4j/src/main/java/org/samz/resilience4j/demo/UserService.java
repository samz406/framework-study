package org.samz.resilience4j.demo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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

    public int getAge(){

        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(15));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 20;
    }

    public String getUserName(Integer num) {

        int i = 2 / num;
        return "结果为" + i;
    }
}
