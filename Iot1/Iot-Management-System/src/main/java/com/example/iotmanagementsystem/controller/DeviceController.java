package com.example.iotmanagementsystem.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.example.iotmanagementsystem.common.Result;
import com.example.iotmanagementsystem.entity.Device;
import com.example.iotmanagementsystem.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能：
 * 作者：刚
 * 日期：2024/3/13 15:59
 */
@CrossOrigin
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Resource
    DeviceService deviceService;

    //新增设备信息
    @PostMapping("/add")
    public Result add(@RequestBody Device device) {
        //添加设备时，给设备设置默认值
        device.setAttribution("");
        device.setIcc("");
        device.setMac("");
        device.setVital("");
        device.setOnline(false);
        deviceService.save(device);
        return Result.success();
    }

    //修改设备信息
    @PutMapping("/update")
    public Result update(@RequestBody Device device) {
        deviceService.updateById(device);
        return Result.success();
    }

    //删除设备信息
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        deviceService.removeById(id);
        return Result.success();
    }

    //批量删除设备信息
    @DeleteMapping("/delete/batch")
    public Result batchDelete(@RequestBody ArrayList<Integer> ids) {
        deviceService.removeBatchByIds(ids);
        return Result.success();
    }

    //查询全部设备信息
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Device> devices = deviceService.list(new QueryWrapper<Device>().orderByDesc("id"));
        return Result.success(devices);
    }

    //查询单个信息,根据id
    @GetMapping("/selectById/{id}")
    public Result selectOne(@PathVariable Integer id) {
        Device device = deviceService.getById(id);
        return Result.success(device);
    }



    //获取设备信息
    @GetMapping("/selectDevicePage")
    public Result selectByPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam String name){
        QueryWrapper<Device> queryWrapper = new QueryWrapper<Device>();
        queryWrapper.like(StrUtil.isNotBlank(name),"name",name);
        return Result.success(deviceService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }
}
