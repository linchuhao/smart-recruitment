package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.ApplicantDao;
import com.zhbit.smartrecruit.data.dto.ApplicantInfo;
import com.zhbit.smartrecruit.data.entity.ApplicantInfoEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.data.vo.ResumeDeliveryRecordVo;
import com.zhbit.smartrecruit.service.ApplicantInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
        applicantInfo.setApplicantInfoMajor(applicantInfoEntity.getApplicantInfoMajor());
        applicantInfo.setApplicantInfoResume(applicantInfoEntity.getApplicantInfoResume());
        return applicantInfo;
    }

    public ResponseMessage getResumeDeliveryRecord(Long userId) {
        List<ResumeDeliveryRecordVo> resumeDeliveryRecord;
        resumeDeliveryRecord = this.baseMapper.getResumeDeliveryRecord(userId);
        if (resumeDeliveryRecord.isEmpty()) {
            return ResponseMessage.failedMessage("没有记录!");
        }
        return ResponseMessage.successMessage(resumeDeliveryRecord);
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
        applicantInfoEntity.setApplicantInfoMajor(applicantInfo.getApplicantInfoMajor());
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
            String relativePath = "static/avatar/" + fileName;
            return saveFilePath("avatar",relativePath,userId);
        } catch (IOException e) {
            return ResponseMessage.failedMessage();
        }
    }

    public ResponseMessage uploadApplicantInfoResume(MultipartFile resume, Long userId) {
        String fileName = resume.getOriginalFilename();
        String path = "E:/毕设/前端/my-project/static/resume/" + fileName;
        File dest = new File(path);
        try {
            resume.transferTo(dest);
            String relativePath = "static/resume/" + fileName;
            return saveFilePath("resume",relativePath,userId);
        }catch (IOException e) {
            return ResponseMessage.failedMessage();
        }
    }

    private ResponseMessage saveFilePath(String type, String relativePath, Long userId) {
        ApplicantInfoEntity applicantInfoEntity = new ApplicantInfoEntity();
        applicantInfoEntity.setApplicantInfoId(userId);
        if (type.equals("avatar")) {
            applicantInfoEntity.setApplicantInfoImg(relativePath);
        }
        if (type.equals("resume")) {
            applicantInfoEntity.setApplicantInfoResume(relativePath);
        }
        boolean result = this.baseMapper.updateById(applicantInfoEntity) > 0;
        if (result) {
            return ResponseMessage.successMessage();
        }
        return ResponseMessage.failedMessage();
    }

}
