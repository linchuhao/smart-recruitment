package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.dto.UserDTO;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UserController
 * @description 用户相关接口
 * @author linchuhao
 * @since 2020/04/01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserInfoService userInfoService;

    /**
     * @method register 用户注册
     * @param user 注册对象
     * @return ResponseMessage
     **/
    @PostMapping("/register")
    @ApiOperation("用户注册")
    public ResponseMessage register(@RequestBody UserDTO user) {
        return userInfoService.register(user);
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public ResponseMessage login(@RequestBody UserDTO user) {
        return userInfoService.login(user);
    }

}
