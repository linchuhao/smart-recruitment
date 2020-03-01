package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.JobDao;
import com.zhbit.smartrecruit.data.entity.JobEntity;
import com.zhbit.smartrecruit.service.JobService;
import org.springframework.stereotype.Service;

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
}
