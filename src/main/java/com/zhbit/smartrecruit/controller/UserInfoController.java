package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.dto.DeliveryRecord;
import com.zhbit.smartrecruit.data.dto.UserInfoDTO;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * UserInfoController
 * @description 用户信息（个人中心）相关接口
 * @author linchuhao
 * @since 2020/04/01
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Resource
    UserInfoService userInfoService;

    @GetMapping("/getUserInfo")
    @ApiOperation("获取用户信息")
    public ResponseMessage getUserInfo(@RequestParam Long userId) {
        return userInfoService.getUserInfo(userId);
    }

    @PostMapping("/updateUserInfoAvatar")
    @ApiOperation("更改用户信息")
    public ResponseMessage updateUserInfo(@RequestBody UserInfoDTO userInfo) {
        return userInfoService.updateUserInfo(userInfo);
    }

    @PostMapping("/uploadUserInfoAvatar")
    @ApiOperation("上传用户头像")
    public ResponseMessage uploadUserInfoAvatar(@RequestParam MultipartFile avatar, @RequestParam Long userId) {
        return userInfoService.uploadUserInfoAvatar(avatar,userId);
    }

    @PostMapping("/uploadApplicantInfoResume")
    @ApiOperation("上传应聘者简历")
    public ResponseMessage uploadApplicantInfoResume(@RequestParam MultipartFile resume, @RequestParam Long userId) {
        return userInfoService.uploadApplicantInfoResume(resume,userId);
    }

    @PostMapping("/deliverResume")
    @ApiOperation("投递简历")
    public ResponseMessage deliverResume(@RequestBody DeliveryRecord deliveryRecord) {
        return userInfoService.deliverResume(deliveryRecord);
    }

    @GetMapping("/getResumeDeliveryRecord")
    @ApiOperation("获取简历投递记录")
    public ResponseMessage getResumeDeliveryRecord(@RequestParam Long userId) {
        return userInfoService.getResumeDeliveryRecord(userId);
    }

    @GetMapping("/getResumeReceiveRecord")
    @ApiOperation("获取简历接收记录")
    public ResponseMessage getResumeReceiveRecord(@RequestParam Long userId) {
        return userInfoService.getResumeReceiveRecord(userId);
    }
}
