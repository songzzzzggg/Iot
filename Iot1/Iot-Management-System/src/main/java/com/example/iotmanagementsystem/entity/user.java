package com.example.iotmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 功能：对应数据库中的user表，实体类。
 * 作者：刚
 * 日期：2024/3/13 15:47
 */
@Data
@TableName("user")
public class user {

    @TableId(type= IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String permission;

}
