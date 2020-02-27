package com.zhbit.smartrecruit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhbit.smartrecruit.data.entity.EnterpriseEntity;
import com.zhbit.smartrecruit.data.vo.EnterpriseVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnterpriseDao extends BaseMapper<EnterpriseEntity> {
    List<EnterpriseVo> getAllEnterprise();
}
