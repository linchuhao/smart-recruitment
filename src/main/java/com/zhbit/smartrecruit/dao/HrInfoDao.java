package com.zhbit.smartrecruit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhbit.smartrecruit.data.entity.HrInfoEntity;
import com.zhbit.smartrecruit.data.vo.ReceiveRecordVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HrInfoDao extends BaseMapper<HrInfoEntity> {
    List<ReceiveRecordVo> getReceiveRecord(Long userId);
}
