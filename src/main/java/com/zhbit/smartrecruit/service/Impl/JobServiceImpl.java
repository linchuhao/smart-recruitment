package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.JobDao;
import com.zhbit.smartrecruit.data.dto.JobInfo;
import com.zhbit.smartrecruit.data.entity.JobEntity;
import com.zhbit.smartrecruit.data.vo.JobReleaseRecordVo;
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

    public ResponseMessage getJobReleaseRecord(Long userId) {
        List<JobReleaseRecordVo> jobReleaseRecordVo;
        jobReleaseRecordVo = this.baseMapper.getJobReleaseRecord(userId);
        if (jobReleaseRecordVo.isEmpty()) {
            return ResponseMessage.failedMessage("没有记录!");
        }
        return ResponseMessage.successMessage(jobReleaseRecordVo);
    }

    public ResponseMessage releaseJobInfo(JobInfo jobInfo) {
        JobEntity jobEntity = new JobEntity();
        jobEntity.setJobFrom(jobInfo.getJobFrom());
        jobEntity.setJobName(jobInfo.getJobName());
        jobEntity.setJobType(jobInfo.getJobType());
        jobEntity.setJobMinSalary(jobInfo.getJobMinSalary());
        jobEntity.setJobMaxSalary(jobInfo.getJobMaxSalary());
        jobEntity.setJobEducation(jobInfo.getJobEducation());
        jobEntity.setJobExperience(jobInfo.getJobExperience());
        jobEntity.setJobCity(jobInfo.getJobCity());
        jobEntity.setJobAddress(jobInfo.getJobAddress());
        jobEntity.setJobResponsibility(jobInfo.getJobResponsibility());
        jobEntity.setJobRequirement(jobInfo.getJobRequirement());
        jobEntity.setJobDatetime(LocalDateTime.now());
        jobEntity.setJobIsActive(true);
        int res =  this.baseMapper.insert(jobEntity);
        if (res > 0) {
            return ResponseMessage.successMessage("职位发布成功！");
        }
        return ResponseMessage.failedMessage("职位发布失败！");
    }

    public ResponseMessage updateJobInfo(JobInfo jobInfo) {
        JobEntity jobEntity = new JobEntity();
        jobEntity.setJobId(jobInfo.getJobId());
        jobEntity.setJobName(jobInfo.getJobName());
        jobEntity.setJobType(jobInfo.getJobType());
        jobEntity.setJobMinSalary(jobInfo.getJobMinSalary());
        jobEntity.setJobMaxSalary(jobInfo.getJobMaxSalary());
        jobEntity.setJobEducation(jobInfo.getJobEducation());
        jobEntity.setJobExperience(jobInfo.getJobExperience());
        jobEntity.setJobCity(jobInfo.getJobCity());
        jobEntity.setJobAddress(jobInfo.getJobAddress());
        jobEntity.setJobResponsibility(jobInfo.getJobResponsibility());
        jobEntity.setJobRequirement(jobInfo.getJobRequirement());
        jobEntity.setJobDatetime(LocalDateTime.now());
        jobEntity.setJobIsActive(true);
        boolean result = this.baseMapper.updateById(jobEntity) > 0;
        if (result) {
            return ResponseMessage.successMessage("修改成功");
        }
        return ResponseMessage.failedMessage("修改失败");
    }

    public ResponseMessage searchJobInfo(String jobName) {
        List<JobReleaseRecordVo> jobReleaseRecord;
        jobReleaseRecord = this.baseMapper.searchJobInfo(jobName);
        if (jobReleaseRecord.isEmpty()) {
            return ResponseMessage.failedMessage("没有记录!");
        }
        return ResponseMessage.successMessage(jobReleaseRecord);
    }
}
