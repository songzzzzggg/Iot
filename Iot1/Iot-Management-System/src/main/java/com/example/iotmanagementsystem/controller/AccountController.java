package com.example.iotmanagementsystem.controller;
import com.example.iotmanagementsystem.common.Result;
import com.example.iotmanagementsystem.entity.user;
import com.example.iotmanagementsystem.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 功能：
 * 作者：刚
 * 日期：2024/3/13 15:59
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    AccountService accountService;


    //修改用户信息
    @PutMapping("/update")
    public Result update(@RequestBody user account) {
        accountService.updateById(account);
        return Result.success();
    }

}
