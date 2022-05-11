package org.samz.mybatisdemo.mapper;

import org.apache.ibatis.annotations.Mapper;

import org.samz.mybatisdemo.entity.UserDO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author: lilin
 * @Date: 2022/5/11 11:01
 * @Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {


}
