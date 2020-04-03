package com.zhbit.smartrecruit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhbit.smartrecruit.data.dto.DeliveryRecord;
import com.zhbit.smartrecruit.data.dto.UserDTO;
import com.zhbit.smartrecruit.data.dto.UserInfoDTO;
import com.zhbit.smartrecruit.data.entity.UserInfoEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import org.springframework.web.multipart.MultipartFile;

public interface UserInfoService extends IService<UserInfoEntity> {

    ResponseMessage register(UserDTO user);

    ResponseMessage login(UserDTO user);

    ResponseMessage getUserInfo(Long userId);

    ResponseMessage updateUserInfo(UserInfoDTO userInfo);

    ResponseMessage uploadUserInfoAvatar(MultipartFile avatar, Long userId);

    ResponseMessage uploadApplicantInfoResume(MultipartFile avatar, Long userId);

    ResponseMessage deliverResume(DeliveryRecord deliveryRecord);

    ResponseMessage getResumeReceiveRecord(Long userId);

    ResponseMessage getResumeDeliveryRecord(Long userId);

}
