package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.dto.UserInfo;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    UserInfoService userInfoService;

    @PostMapping("/register")
    @ApiOperation("注册")
    public ResponseMessage register(@RequestBody UserInfo userInfo) {
        return userInfoService.register(userInfo);
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseMessage login(@RequestBody UserInfo userInfo) {
        return userInfoService.login(userInfo);
    }
}