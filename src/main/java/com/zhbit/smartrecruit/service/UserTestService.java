package com.zhbit.smartrecruit.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.zhbit.smartrecruit.data.dto.User;
import com.zhbit.smartrecruit.data.entity.UserTestEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;

public interface UserTestService  extends IService<UserTestEntity> {

    ResponseMessage regist(User user);
}
