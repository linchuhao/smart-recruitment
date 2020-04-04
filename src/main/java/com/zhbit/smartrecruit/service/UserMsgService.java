package com.zhbit.smartrecruit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhbit.smartrecruit.data.entity.MessageEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;

public interface UserMsgService extends IService<MessageEntity> {

    ResponseMessage getUserMsg(Long userId);
}
