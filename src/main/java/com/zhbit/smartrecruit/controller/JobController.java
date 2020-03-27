package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.dto.JobInfo;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.JobService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/releaseJobInfo")
    @ApiOperation("发布职位信息")
    public ResponseMessage releaseJobInfo(@RequestBody JobInfo jobInfo) {
        return jobService.releaseJobInfo(jobInfo);
    }

    @PostMapping("/searchJobInfo")
    @ApiOperation("搜索职位信息")
    public ResponseMessage searchJobInfo(@RequestParam String jobName) {
        return ResponseMessage.successMessage("to do");
    }
}
