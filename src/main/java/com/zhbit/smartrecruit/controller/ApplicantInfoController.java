package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.dto.ApplicantInfo;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.ApplicantInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/applicant")
public class ApplicantInfoController {

    @Resource
    ApplicantInfoService applicantInfoService;

    @GetMapping("/getApplicantInfo")
    @ApiOperation("获取应聘者信息")
    public ApplicantInfo getApplicantInfo(@RequestParam String userId) {
        return applicantInfoService.getApplicantInfo(userId);
    }

    @PostMapping("/updateApplicantInfo")
    @ApiOperation("修改应聘者信息")
    public ResponseMessage updateApplicantInfo(@RequestBody ApplicantInfo applicantInfo) {
        return applicantInfoService.updateApplicantInfo(applicantInfo);
    }
}
