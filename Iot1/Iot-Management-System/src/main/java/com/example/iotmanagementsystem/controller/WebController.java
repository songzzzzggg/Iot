package com.example.iotmanagementsystem.controller;

import cn.hutool.core.util.StrUtil;

import com.example.iotmanagementsystem.common.Result;
import com.example.iotmanagementsystem.entity.user;
import com.example.iotmanagementsystem.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 功能：登录注册功能的实现
 * 作者：刚
 * 日期：2024/4/12 15:47
 */

@RestController
public class WebController {

    @Resource
    AccountService accountService;




    @PostMapping("/register")
    public Result register(@RequestBody user account){
        if(StrUtil.isBlank(account.getUsername())||StrUtil.isBlank(account.getPassword())){
            //使用hutool中的封装方法，判别传过来的数据是否为空
            return Result.error("数据输入不合法");
        }
        if(account.getUsername().length()>10||account.getPassword().length()>20){
            return Result.error("数据输入不合法");
        }
        account  = accountService.register(account);
        return Result.success(account);
    }



    @PostMapping("/login")
    public Result login(@RequestBody user account){
        if(StrUtil.isBlank(account.getUsername())||StrUtil.isBlank(account.getPassword())){
            //使用hutool中的封装方法，判别传过来的数据是否为空
            return Result.error("数据输入不合法");
        }

        user dbAccount = accountService.login(account);

        return Result.success(dbAccount);
    }

}
