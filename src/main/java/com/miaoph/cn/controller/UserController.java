package com.miaoph.cn.controller;

import com.miaoph.cn.entity.PhUser;
import com.miaoph.cn.service.IUserService;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@ApiModel("测试controller")
public class UserController {

    @Autowired
    IUserService iUerService;
    @GetMapping("/get")
    public  String  queryUser(){
        final PhUser user = iUerService.getUser();
        return user.toString();

    }
}
