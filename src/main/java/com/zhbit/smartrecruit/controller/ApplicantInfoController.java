package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.dto.ApplicantInfo;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.ApplicantInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/applicant")
public class ApplicantInfoController {

    @Resource
    ApplicantInfoService applicantInfoService;

    @GetMapping("/getApplicantInfo")
    @ApiOperation("获取应聘者信息")
    public ApplicantInfo getApplicantInfo(@RequestParam Long userId) {
        return applicantInfoService.getApplicantInfo(userId);
    }

    @PostMapping("/updateApplicantInfo")
    @ApiOperation("修改应聘者信息")
    public ResponseMessage updateApplicantInfo(@RequestBody ApplicantInfo applicantInfo) {
        return applicantInfoService.updateApplicantInfo(applicantInfo);
    }

    @PostMapping("/uploadApplicantInfoAvatar")
    @ApiOperation("上传应聘者头像")
    public ResponseMessage uploadApplicantInfoAvatar(@RequestParam MultipartFile avatar, @RequestParam Long userId) {
        return applicantInfoService.uploadApplicantInfoAvatar(avatar,userId);
    }

    @PostMapping("/uploadApplicantInfoResume")
    @ApiOperation("上传应聘者简历")
    public ResponseMessage uploadApplicantInfoResume(@RequestParam MultipartFile resume, @RequestParam Long userId) {
        return applicantInfoService.uploadApplicantInfoResume(resume,userId);
    }
}
