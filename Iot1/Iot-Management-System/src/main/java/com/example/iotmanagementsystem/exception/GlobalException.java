package com.example.iotmanagementsystem.exception;

import com.example.iotmanagementsystem.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能：全局异常捕获器
 * 作者：刚
 * 日期：2024/3/18 13:07
 */
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ServiceException.class)//捕获异常
    @ResponseBody//将Result对象转换为Json数据
    public Result serviceException(ServiceException e){
        return Result.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)//捕获异常
    @ResponseBody//将Result对象转换为Json数据
    public Result globalException(Exception e){
        System.out.println("错误信息"+e.getMessage());
        return Result.error("500","系统错误");
    }

}
