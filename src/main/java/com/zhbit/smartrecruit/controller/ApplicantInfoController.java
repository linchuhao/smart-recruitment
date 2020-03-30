package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.dto.ApplicantInfo;
import com.zhbit.smartrecruit.data.dto.DeliveryRecord;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.ApplicantInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


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

    @GetMapping("/getResumeDeliveryRecord")
    @ApiOperation("获取简历投递记录")
    public ResponseMessage getResumeDeliveryRecord(@RequestParam Long userId) {
        return applicantInfoService.getResumeDeliveryRecord(userId);
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

    @PostMapping("/deliverResume")
    @ApiOperation("投递简历")
    public ResponseMessage deliverResume(@RequestBody DeliveryRecord deliveryRecord) {
        return applicantInfoService.deliverResume(deliveryRecord);
    }
}
