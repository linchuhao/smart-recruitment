package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.JobDao;
import com.zhbit.smartrecruit.data.dto.JobInfo;
import com.zhbit.smartrecruit.data.entity.JobEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.JobService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl extends ServiceImpl<JobDao, JobEntity> implements JobService {

    public List<JobEntity> getAllJob() {
        List<JobEntity> job;
        job = this.baseMapper.selectList(null)
                .stream().filter(JobEntity::isJobIsActive)
                .collect(Collectors.toList());
        return job;
    }

    public List<JobEntity> getHotJob() {
        List<JobEntity> job;
        job = getAllJob().stream().filter(JobEntity::isJobIsHot)
                .collect(Collectors.toList());
        return job;
    }

    public ResponseMessage deliveryJobInfo(JobInfo jobInfo) {
        JobEntity jobEntity = new JobEntity();
        jobEntity.setJobFrom(jobInfo.getJobFrom());
        jobEntity.setJobName(jobInfo.getJobName());
        jobEntity.setJobProperty(jobInfo.getJobProperty());
        jobEntity.setJobMinSalary(jobInfo.getJobMinSalary());
        jobEntity.setJobMaxSalary(jobInfo.getJobMaxSalary());
        jobEntity.setJobCity(jobInfo.getJobCity());
        jobEntity.setJobAddress(jobInfo.getJobAddress());
        // to do
        //把职位要求按段切分，然后填进html的标签里面
        jobEntity.setJobRequirement(jobInfo.getJobRequirement());
        jobEntity.setJobDatetime(LocalDateTime.now());
        jobEntity.setJobIsActive(true);
        int res =  this.baseMapper.insert(jobEntity);
        if (res > 0) {
            return ResponseMessage.successMessage("职位发布成功！");
        }
        return ResponseMessage.failedMessage("职位发布失败！");
    }
}
