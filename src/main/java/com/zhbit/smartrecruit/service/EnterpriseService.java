package com.zhbit.smartrecruit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhbit.smartrecruit.data.entity.EnterpriseEntity;
import com.zhbit.smartrecruit.data.vo.EnterpriseVo;

import java.util.List;

public interface EnterpriseService extends IService<EnterpriseEntity> {

    List<EnterpriseVo> getAllEnterprise();

    List<EnterpriseVo> getHotEnterprise();
}
