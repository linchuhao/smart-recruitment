package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.dto.HrInfo;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.HrInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hr")
public class HrInfoController {

    @Resource
    HrInfoService hrInfoService;

    @GetMapping("/getHrInfo")
    @ApiOperation("获取HR信息")
    public HrInfo getHrInfo(@RequestParam Long userId) {
        return hrInfoService.getHrInfo(userId);
    }

    @PostMapping("/updateHrInfo")
    @ApiOperation("修改HR信息")
    public ResponseMessage updateHrInfo(@RequestBody HrInfo hrInfo) {
        return hrInfoService.updateHrInfo(hrInfo);
    }

    @PostMapping("/uploadHrInfoAvatar")
    @ApiOperation("上传HR头像")
    public ResponseMessage uploadHrInfoAvatar(@RequestParam MultipartFile avatar, @RequestParam Long userId) {
        return hrInfoService.uploadHrInfoAvatar(avatar,userId);
    }
}
