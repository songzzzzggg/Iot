package com.example.iotmanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 功能：对应数据库中的device表，实体类。
 * 作者：刚
 * 日期：2024/3/13 15:47
 */
@Data
@TableName("device")
public class Device {

    @TableId(type= IdType.AUTO)
    private Integer id;
    private String name;
    private Boolean  online;
    private Boolean  status;
    private String  vital;
    private String  mac;
    private String  icc;
    private String  attribution;
}
