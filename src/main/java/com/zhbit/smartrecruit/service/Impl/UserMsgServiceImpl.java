package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.UserMsgDao;
import com.zhbit.smartrecruit.data.entity.MessageEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.data.vo.UserMsgVo;
import com.zhbit.smartrecruit.service.UserMsgService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserMsgServiceImpl extends ServiceImpl<UserMsgDao, MessageEntity> implements UserMsgService {

    @Override
    public ResponseMessage getUserMsg(Long userId) {
        List<UserMsgVo> userMsgVO = this.baseMapper.getUserMsg(userId);
        if (userMsgVO.isEmpty()){
            return ResponseMessage.failedMessage();
        }
        return ResponseMessage.successMessage(userMsgVO);
    }
}
