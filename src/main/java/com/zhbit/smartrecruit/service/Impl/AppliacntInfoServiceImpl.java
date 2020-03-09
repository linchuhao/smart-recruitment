package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.ApplicantDao;
import com.zhbit.smartrecruit.data.dto.ApplicantInfo;
import com.zhbit.smartrecruit.data.entity.ApplicantInfoEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.ApplicantInfoService;
import org.springframework.stereotype.Service;

@Service
public class AppliacntInfoServiceImpl extends ServiceImpl<ApplicantDao, ApplicantInfoEntity> implements ApplicantInfoService {

    public ApplicantInfo getApplicantInfo(String userId) {
        ApplicantInfoEntity applicantInfoEntity = this.baseMapper.selectById(userId);
        ApplicantInfo applicantInfo = new ApplicantInfo();
        applicantInfo.setApplicantInfoId(applicantInfoEntity.getApplicantInfoId());
        applicantInfo.setApplicantInfoName(applicantInfoEntity.getApplicantInfoName());
        applicantInfo.setApplicantInfoProperty(applicantInfoEntity.getApplicantInfoProperty());
        applicantInfo.setApplicantInfoPhone(applicantInfoEntity.getApplicantInfoPhone());
        applicantInfo.setApplicantInfoEmail(applicantInfoEntity.getApplicantInfoEmail());
        applicantInfo.setApplicantInfoSex(applicantInfoEntity.getApplicantInfoSex());
        applicantInfo.setApplicantInfoAddress(applicantInfoEntity.getApplicantInfoAddress());
        applicantInfo.setApplicantInfoIntroduction(applicantInfoEntity.getApplicantInfoIntroduction());
        applicantInfo.setApplicantInfoEducation(applicantInfoEntity.getApplicantInfoEducation());
        applicantInfo.setApplicantInfoSchool(applicantInfoEntity.getApplicantInfoSchool());
        applicantInfo.setApplicantInfoImg(applicantInfoEntity.getApplicantInfoImg());
        applicantInfo.setApplicantInfoResume(applicantInfoEntity.getApplicantInfoResume());
        return applicantInfo;
    }

    public ResponseMessage updateApplicantInfo(ApplicantInfo applicantInfo) {
        ApplicantInfoEntity applicantInfoEntity = new ApplicantInfoEntity();
        applicantInfoEntity.setApplicantInfoId(applicantInfo.getApplicantInfoId());
        applicantInfoEntity.setApplicantInfoName(applicantInfo.getApplicantInfoName());
        applicantInfoEntity.setApplicantInfoProperty(applicantInfo.getApplicantInfoProperty());
        applicantInfoEntity.setApplicantInfoPhone(applicantInfo.getApplicantInfoPhone());
        applicantInfoEntity.setApplicantInfoEmail(applicantInfo.getApplicantInfoEmail());
        applicantInfoEntity.setApplicantInfoSex(applicantInfo.getApplicantInfoSex());
        applicantInfoEntity.setApplicantInfoAddress(applicantInfo.getApplicantInfoAddress());
        applicantInfoEntity.setApplicantInfoIntroduction(applicantInfo.getApplicantInfoIntroduction());
        applicantInfoEntity.setApplicantInfoEducation(applicantInfo.getApplicantInfoEducation());
        applicantInfoEntity.setApplicantInfoSchool(applicantInfo.getApplicantInfoSchool());
        applicantInfoEntity.setApplicantInfoImg(applicantInfo.getApplicantInfoImg());
        applicantInfoEntity.setApplicantInfoResume(applicantInfo.getApplicantInfoResume());
        boolean result = this.baseMapper.updateById(applicantInfoEntity) > 0;
        if (result) {
            return ResponseMessage.successMessage("修改成功");
        }
        return ResponseMessage.failedMessage("修改失败");
    }
}
