package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.JobService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/job")
public class JobController {

    @Resource
    JobService jobService;

    @GetMapping("/getAllJob")
    @ApiOperation("获取所有职位信息")
    public ResponseMessage getAllJob() {
        return ResponseMessage.successMessage(jobService.getAllJob());
    }

    @GetMapping("/getHotJob")
    @ApiOperation("获取所有热门职位信息")
    public ResponseMessage getHotJob() {
        return ResponseMessage.successMessage(jobService.getHotJob());
    }
}
