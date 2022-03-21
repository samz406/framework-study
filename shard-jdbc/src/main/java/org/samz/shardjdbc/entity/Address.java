package org.samz.shardjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("t_address")
public class Address {

    private Long id;

    private String address;


}
