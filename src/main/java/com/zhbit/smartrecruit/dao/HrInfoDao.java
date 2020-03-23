package com.zhbit.smartrecruit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhbit.smartrecruit.data.entity.HrInfoEntity;
import com.zhbit.smartrecruit.data.vo.JobDeliveryRecordVo;
import com.zhbit.smartrecruit.data.vo.ReceiveRecordVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HrInfoDao extends BaseMapper<HrInfoEntity> {
    List<ReceiveRecordVo> getResumeReceiveRecord(Long userId);

    List<JobDeliveryRecordVo> getJobDeliveryRecord(Long userId);
}
