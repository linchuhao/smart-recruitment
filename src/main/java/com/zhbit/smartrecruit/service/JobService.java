package com.zhbit.smartrecruit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhbit.smartrecruit.data.dto.JobInfo;
import com.zhbit.smartrecruit.data.entity.JobEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;

import java.util.List;

public interface JobService extends IService<JobEntity> {

    List<JobEntity> getAllJob();

    List<JobEntity> getHotJob();

    ResponseMessage deliveryJobInfo(JobInfo jobInfo);

}
