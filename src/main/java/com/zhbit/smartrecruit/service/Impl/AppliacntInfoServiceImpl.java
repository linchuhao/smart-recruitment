package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.ApplicantDao;
import com.zhbit.smartrecruit.data.dto.ApplicantInfo;
import com.zhbit.smartrecruit.data.entity.ApplicantInfoEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.ApplicantInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class AppliacntInfoServiceImpl extends ServiceImpl<ApplicantDao, ApplicantInfoEntity> implements ApplicantInfoService {

    public ApplicantInfo getApplicantInfo(Long userId) {
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

    public ResponseMessage uploadApplicantInfoAvatar(MultipartFile avatar, Long userId) {
        String originalName = avatar.getOriginalFilename();
        String fileSuffix = originalName.substring(originalName.lastIndexOf(".")).toLowerCase();
        String fileName = "Applicant" + userId + fileSuffix;
        String path = "E:/毕设/前端/my-project/static/avatar/" + fileName;
        File dest = new File(path);
        try {
            avatar.transferTo(dest);
            return storeAvatar(fileName,userId);
        } catch (IOException e) {
            return ResponseMessage.failedMessage();
        }
    }

    private ResponseMessage storeAvatar(String fileName, Long userId) {
        ApplicantInfoEntity applicantInfoEntity = new ApplicantInfoEntity();
        applicantInfoEntity.setApplicantInfoId(userId);
        applicantInfoEntity.setApplicantInfoImg("static/avatar/" + fileName);
        boolean result = this.baseMapper.updateById(applicantInfoEntity) > 0;
        if (result) {
            return ResponseMessage.successMessage();
        }
        return ResponseMessage.failedMessage();
    }
}
