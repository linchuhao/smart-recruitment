package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.UserMsgService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userMsg")
public class UserMsgController {

    @Resource
    UserMsgService userMsgService;

    @GetMapping("/getUserMsg")
    @ApiOperation("获取用户消息")
    public ResponseMessage getUserMsg(@RequestParam Long userId) {
        return userMsgService.getUserMsg(userId);
    }
}
