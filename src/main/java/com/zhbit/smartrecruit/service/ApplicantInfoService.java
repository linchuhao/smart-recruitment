package com.zhbit.smartrecruit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhbit.smartrecruit.data.dto.ApplicantInfo;
import com.zhbit.smartrecruit.data.entity.ApplicantInfoEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;

public interface ApplicantInfoService extends IService<ApplicantInfoEntity> {

    ApplicantInfo getApplicantInfo(String userId);

    ResponseMessage updateApplicantInfo(ApplicantInfo applicantInfo);

}
