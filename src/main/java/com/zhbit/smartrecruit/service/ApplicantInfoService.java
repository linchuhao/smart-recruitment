package com.zhbit.smartrecruit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhbit.smartrecruit.data.dto.ApplicantInfo;
import com.zhbit.smartrecruit.data.entity.ApplicantInfoEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import org.springframework.web.multipart.MultipartFile;

public interface ApplicantInfoService extends IService<ApplicantInfoEntity> {

    ApplicantInfo getApplicantInfo(Long userId);

    ResponseMessage getResumeDeliveryRecord(Long userId);

    ResponseMessage updateApplicantInfo(ApplicantInfo applicantInfo);

    ResponseMessage uploadApplicantInfoAvatar(MultipartFile avatar, Long userId);

    ResponseMessage uploadApplicantInfoResume(MultipartFile avatar, Long userId);

}
