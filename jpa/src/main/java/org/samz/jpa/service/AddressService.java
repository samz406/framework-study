package org.samz.jpa.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.samz.jpa.repo.AddressEntity;
import org.samz.jpa.repo.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author: lilin
 * @Date: 2022/1/20 14:11
 * @Description:
 */
@Service
public class AddressService {

    @Resource
    private AddressRepository addressRepository;

    @Transactional()
    public void save(AddressEntity addressEntity){

        Assert.notNull(addressEntity,"参数不能为空");
        addressRepository.save(addressEntity);
    }
}
