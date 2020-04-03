package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userMsg")
public class UserMsgController {

    @GetMapping("/getUserMsg")
    @ApiOperation("获取用户消息")
    public ResponseMessage getUserMsg(@RequestParam Long userId, @RequestParam int role) {
        return ResponseMessage.failedMessage("to do");
    }
}
