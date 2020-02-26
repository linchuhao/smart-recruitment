package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.dto.Result;
import com.zhbit.smartrecruit.data.dto.User;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.UserTestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/userTest")
public class UserTestController {

    @Autowired
    private UserTestService userTestService;

    @PostMapping("/regist")
    @ApiOperation("测试regist")
    public ResponseMessage regist(@RequestBody User user){
         return userTestService.regist(user);
    }

}
