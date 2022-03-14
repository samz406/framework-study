package org.samz.shardjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("t_dict")
public class Dict {

    private Long id;

    private  String code;

    private String value;
}
