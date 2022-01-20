package org.samz.jpa.service;

import java.lang.ref.PhantomReference;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.samz.jpa.repo.UserEntity;
import org.samz.jpa.repo.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author: lilin
 * @Date: 2022/1/20 10:47
 * @Description:
 */

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private AddressService addressService;

    @Transactional(value = TxType.REQUIRES_NEW)
    public void save(UserEntity userEntity){

        addressService.save(null);
        userRepository.save(userEntity);
    }
}
