package com.zhbit.smartrecruit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhbit.smartrecruit.data.entity.ApplicantInfoEntity;
import org.springframework.stereotype.Service;

@Service
public interface ApplicantDao extends BaseMapper<ApplicantInfoEntity> {
}
