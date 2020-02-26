package com.zhbit.smartrecruit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhbit.smartrecruit.data.dto.UserInfo;
import com.zhbit.smartrecruit.data.entity.UserInfoEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;

public interface UserInfoService extends IService<UserInfoEntity> {

    ResponseMessage register(UserInfo userInfo);

    ResponseMessage login(UserInfo userInfo);
}
