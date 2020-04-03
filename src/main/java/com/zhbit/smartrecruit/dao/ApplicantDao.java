package com.zhbit.smartrecruit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhbit.smartrecruit.data.entity.ApplicantInfoEntity;
import com.zhbit.smartrecruit.data.vo.ResumeDeliveryRecordVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicantDao extends BaseMapper<ApplicantInfoEntity> {
}
