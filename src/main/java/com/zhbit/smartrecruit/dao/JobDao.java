package com.zhbit.smartrecruit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhbit.smartrecruit.data.entity.JobEntity;
import com.zhbit.smartrecruit.data.vo.JobReleaseRecordVo;

import java.util.List;

public interface JobDao extends BaseMapper<JobEntity> {
    List<JobReleaseRecordVo> searchJobInfo(String jobName);

    List<JobReleaseRecordVo> getJobReleaseRecord(Long userId);
}
