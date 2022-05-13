package org.samz.jpa.service;

import org.springframework.stereotype.Service;

/**
 * @author: lilin
 * @Date: 2022/5/13 15:07
 * @Description:
 */
@Service
public class RoleService {

    public String getRole(){

        return "admin";
    }
}
