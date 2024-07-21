package com.example.iotmanagementsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.iotmanagementsystem.entity.user;
import com.example.iotmanagementsystem.exception.ServiceException;
import com.example.iotmanagementsystem.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 功能：
 * 作者：刚
 * 日期：2024/3/13 15:59
 */
@Service
public class AccountService extends ServiceImpl<AccountMapper, user> {

    @Resource
    AccountMapper accountMapper;

    public user selectByUsername(String username) {
        QueryWrapper<user> queryWrapper = new QueryWrapper<user>();//构造一个条件查询器
        queryWrapper.eq("username", username);//添加一个条件
        return getOne(queryWrapper);//根据条件查询,getOne是ServiceImpl中的方法。
    }


    //去account表中比较用户名和密码
    public user login(user account) {
        //根据用户名查询数据库
        user dbAccount = selectByUsername(account.getUsername());
        if (dbAccount == null) {
            //查询结果为空，抛出异常
            throw new ServiceException("用户名或密码错误");
        }
        if (!dbAccount.getPassword().equals(account.getPassword())) {
            //前端传过来的密码与后端获取的密码不同，抛出异常
            throw new ServiceException("用户名或密码错误");
        }
        return dbAccount;
    }


    public user register(user account) {
        //先根据用户名进行查询，确保用户名不重复
        user dbAccount = selectByUsername(account.getUsername());
        if (dbAccount != null) {
            //用户名重复，抛出异常
            throw new ServiceException("用户名已存在");
        }
        accountMapper.insert(account);//注册成功，向user表中插入一条数据
        return dbAccount;
    }

        public void resetPassword(user account) {
            user dbAccount = selectByUsername(account.getUsername());
        if (dbAccount == null) {
            //查询结果为空，抛出异常
            throw new ServiceException("用户不存在");
        }
            dbAccount.setPassword("123");//重置密码
        updateById(dbAccount);
    }
}
