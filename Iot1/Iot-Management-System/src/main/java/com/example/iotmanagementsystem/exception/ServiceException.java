package com.example.iotmanagementsystem.exception;

import lombok.Getter;

/**
 * 功能：
 * 作者：刚
 * 日期：2024/3/18 13:11
 */
@Getter
public class ServiceException extends RuntimeException{

    private final String code;

    public ServiceException(String msg){
        super(msg);
        this.code =  "500";//默认返回的是500
    }


    public ServiceException(String code,String msg){
        super(msg);
        this.code = code;
    }


}
