package com.zhbit.smartrecruit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhbit.smartrecruit.data.dto.UserInfoDTO;
import com.zhbit.smartrecruit.data.entity.UserInfoEntity;
import com.zhbit.smartrecruit.data.vo.ReceiveRecordVo;
import com.zhbit.smartrecruit.data.vo.ResumeDeliveryRecordVo;

import java.util.List;

public interface UserInfoDao extends BaseMapper<UserInfoEntity> {
    UserInfoDTO getUserInfo(Long userId);

    List<ReceiveRecordVo> getResumeReceiveRecord(Long userId);

    List<ResumeDeliveryRecordVo> getResumeDeliveryRecord(Long userId);
}
