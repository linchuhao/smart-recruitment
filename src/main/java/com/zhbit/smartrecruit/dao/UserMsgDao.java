package com.zhbit.smartrecruit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhbit.smartrecruit.data.entity.MessageEntity;
import com.zhbit.smartrecruit.data.vo.UserMsgVo;

import java.util.List;

public interface UserMsgDao extends BaseMapper<MessageEntity> {
    List<UserMsgVo> getUserMsg(Long userId);
}
