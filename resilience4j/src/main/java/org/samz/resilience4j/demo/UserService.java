package org.samz.resilience4j.demo;

/**
 * @author: lilin
 * @Date: 2021/12/7 19:13
 * @Description:
 */
public class UserService {


    public String getUserName(){

        int i = 2/0;
        return "";
    }
}
