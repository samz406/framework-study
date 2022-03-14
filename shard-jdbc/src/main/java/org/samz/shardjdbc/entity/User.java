package org.samz.shardjdbc.entity;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("t_user")
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String address;

    private String phone;
}
