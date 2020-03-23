package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.EnterpriseDao;
import com.zhbit.smartrecruit.dao.HrInfoDao;
import com.zhbit.smartrecruit.data.dto.HrInfo;
import com.zhbit.smartrecruit.data.entity.ApplicantInfoEntity;
import com.zhbit.smartrecruit.data.entity.HrInfoEntity;
import com.zhbit.smartrecruit.data.vo.JobDeliveryRecordVo;
import com.zhbit.smartrecruit.data.vo.ReceiveRecordVo;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.HrInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class HrInfoServiceImpl extends ServiceImpl<HrInfoDao, HrInfoEntity> implements HrInfoService {

    @Resource
    EnterpriseDao enterpriseDao;

    @Resource
    UserInfoServiceImpl userInfoServiceImpl;

    public HrInfo getHrInfo(Long userId) {
        HrInfoEntity hrInfoEntity = this.baseMapper.selectById(userId);
        HrInfo hrInfo = new HrInfo();
        if (hrInfoEntity.getHrInfoEnterpriseId() != null) {
            hrInfo.setHrInfoEnterpriseName(enterpriseDao.selectById(hrInfoEntity.getHrInfoEnterpriseId()).getEnterpriseName());
        }
        hrInfo.setHrInfoId(hrInfoEntity.getHrInfoId());
        hrInfo.setHrInfoName(hrInfoEntity.getHrInfoName());
        hrInfo.setHrInfoProperty(hrInfoEntity.getHrInfoProperty());
        hrInfo.setHrInfoPhone(hrInfoEntity.getHrInfoPhone());
        hrInfo.setHrInfoEmail(hrInfoEntity.getHrInfoEmail());
        hrInfo.setHrInfoSex(hrInfoEntity.getHrInfoSex());
        hrInfo.setHrInfoIntroduction(hrInfoEntity.getHrInfoIntroduction());
        hrInfo.setHrInfoEducation(hrInfoEntity.getHrInfoEducation());
        hrInfo.setHrInfoSchool(hrInfoEntity.getHrInfoSchool());
        hrInfo.setHrInfoImg(hrInfoEntity.getHrInfoImg());
        return hrInfo;
    }

    public ResponseMessage updateHrInfo(HrInfo hrInfo) {
        HrInfoEntity hrInfoEntity = new HrInfoEntity();
        hrInfoEntity.setHrInfoId(hrInfo.getHrInfoId());
        hrInfoEntity.setHrInfoName(hrInfo.getHrInfoName());
        hrInfoEntity.setHrInfoEnterpriseId(userInfoServiceImpl.searchEnterprise(hrInfo.getHrInfoEnterpriseName()));
        hrInfoEntity.setHrInfoProperty(hrInfo.getHrInfoProperty());
        hrInfoEntity.setHrInfoPhone(hrInfo.getHrInfoPhone());
        hrInfoEntity.setHrInfoEmail(hrInfo.getHrInfoEmail());
        hrInfoEntity.setHrInfoSex(hrInfo.getHrInfoSex());
        hrInfoEntity.setHrInfoIntroduction(hrInfo.getHrInfoIntroduction());
        hrInfoEntity.setHrInfoEducation(hrInfo.getHrInfoEducation());
        hrInfoEntity.setHrInfoSchool(hrInfo.getHrInfoSchool());
        boolean result = this.baseMapper.updateById(hrInfoEntity) > 0;
        if (result) {
            return ResponseMessage.successMessage("修改成功");
        }
        return ResponseMessage.failedMessage("修改失败");
    }

    public ResponseMessage uploadHrInfoAvatar(MultipartFile avatar, Long userId) {
        String originalName = avatar.getOriginalFilename();
        String fileSuffix = originalName.substring(originalName.lastIndexOf(".")).toLowerCase();
        String fileName = "HR" + userId + fileSuffix;
        String path = "E:/毕设/前端/my-project/static/avatar/" + fileName;
        File dest = new File(path);
        try {
            avatar.transferTo(dest);
            String relativePath = "static/avatar/" + fileName;
            return saveFilePath(relativePath,userId);
        } catch (IOException e) {
            return ResponseMessage.failedMessage();
        }
    }

    private ResponseMessage saveFilePath(String relativePath, Long userId) {
        HrInfoEntity hrInfoEntity = new HrInfoEntity();
        hrInfoEntity.setHrInfoId(userId);
        hrInfoEntity.setHrInfoImg(relativePath);
        boolean result = this.baseMapper.updateById(hrInfoEntity) > 0;
        if (result) {
            return ResponseMessage.successMessage();
        }
        return ResponseMessage.failedMessage();
    }

    public ResponseMessage getResumeReceiveRecord(Long userId) {
        List<ReceiveRecordVo> receiveRecord;
        receiveRecord = this.baseMapper.getResumeReceiveRecord(userId);
        if (receiveRecord.isEmpty()) {
            return ResponseMessage.failedMessage("没有记录!");
        }
        return ResponseMessage.successMessage(receiveRecord);
    }
    public ResponseMessage getJobDeliveryRecord(Long userId) {
        List<JobDeliveryRecordVo> jobDeliveryRecord;
        jobDeliveryRecord = this.baseMapper.getJobDeliveryRecord(userId);
        if (jobDeliveryRecord.isEmpty()) {
            return ResponseMessage.failedMessage("没有记录!");
        }
        return ResponseMessage.successMessage(jobDeliveryRecord);
    }
}
