package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.EnterpriseDao;
import com.zhbit.smartrecruit.data.entity.EnterpriseEntity;
import com.zhbit.smartrecruit.data.vo.EnterpriseVo;
import com.zhbit.smartrecruit.service.EnterpriseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseDao, EnterpriseEntity> implements EnterpriseService {

    public List<EnterpriseVo> getAllEnterprise() {
        List<EnterpriseVo> enterpriseList;
        enterpriseList = this.baseMapper.getAllEnterprise();
        return enterpriseList;
    }

    public List<EnterpriseVo> getHotEnterprise() {
        List<EnterpriseVo> enterpriseList;
        enterpriseList = getAllEnterprise().stream()
                .filter(EnterpriseVo::getEnterpriseIsHot)
                .collect(Collectors.toList());
        return enterpriseList;
    }
}
