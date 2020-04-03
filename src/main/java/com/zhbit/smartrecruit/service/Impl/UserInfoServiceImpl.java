package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.DeliveryRecordDao;
import com.zhbit.smartrecruit.dao.EnterpriseDao;
import com.zhbit.smartrecruit.dao.UserInfoDao;
import com.zhbit.smartrecruit.data.dto.DeliveryRecord;
import com.zhbit.smartrecruit.data.dto.UserDTO;
import com.zhbit.smartrecruit.data.dto.UserInfo;
import com.zhbit.smartrecruit.data.dto.UserInfoDTO;
import com.zhbit.smartrecruit.data.entity.*;
import com.zhbit.smartrecruit.data.vo.ReceiveRecordVo;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.data.vo.ResumeDeliveryRecordVo;
import com.zhbit.smartrecruit.data.vo.UserInfoVo;
import com.zhbit.smartrecruit.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

    @Resource
    EnterpriseDao enterpriseDao;

    @Resource
    DeliveryRecordDao deliveryRecordDao;

    @Override
    public ResponseMessage register(UserDTO user) {
        boolean existUser = existUser(user);
        if (!existUser) {
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.setUserInfoUsername(user.getUsername());
            userInfoEntity.setUserInfoPassword(user.getPassword());
            userInfoEntity.setUserInfoRole(user.getRole());
            userInfoEntity.setUserInfoIsActive(true);
            //HR注册
            if (user.getRole() == 2) {
                if (StringUtils.isNotEmpty(user.getEnterpriseName())) {
                    Long enterpriseId = searchEnterprise(user.getEnterpriseName());
                    userInfoEntity.setUserInfoEnterpriseId(enterpriseId);
                }
            }
            /*
            此处的uuid为自增的，My-Batis先在实体类（执行体）上产生自增uuid后再执行insert方法，
            因此可以通过实体类获得它产生的自增uuid
             */
            this.baseMapper.insert(userInfoEntity);
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setUserId(userInfoEntity.getUserInfoId());
            userInfoVo.setRole(userInfoEntity.getUserInfoRole());
            return ResponseMessage.successMessage(userInfoVo);
        }
        return ResponseMessage.failedMessage("用户已存在");
    }



    @Override
    public ResponseMessage login(UserDTO user) {
        //SELECT * FROM user_info WHERE user_info.username = ? and user_info.password = ?
        QueryWrapper<UserInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfoEntity::getUserInfoUsername,user.getUsername())
        .eq(UserInfoEntity::getUserInfoPassword,user.getPassword());
        UserInfoEntity userInfoEntity = this.baseMapper.selectOne(queryWrapper);
        if (userInfoEntity != null) {
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setUserId(userInfoEntity.getUserInfoId());
            userInfoVo.setRole(userInfoEntity.getUserInfoRole());
            return ResponseMessage.successMessage(userInfoVo);
        }
        return ResponseMessage.failedMessage("登录失败");
    }

    @Override
    public ResponseMessage getUserInfo(Long userId) {
        UserInfoDTO userInfo = this.baseMapper.getUserInfo(userId);
        if (userInfo == null){
            return ResponseMessage.failedMessage();
        }
        return ResponseMessage.successMessage(userInfo);
    }

    @Override
    public ResponseMessage updateUserInfo(UserInfoDTO userInfo) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserInfoNickname(userInfo.getUserInfoNickname());
        userInfoEntity.setUserInfoPosition(userInfo.getUserInfoPosition());
        userInfoEntity.setUserInfoPhone(userInfo.getUserInfoPhone());
        userInfoEntity.setUserInfoEmail(userInfo.getUserInfoEmail());
        userInfoEntity.setUserInfoSex(userInfo.getUserInfoSex());
        userInfoEntity.setUserInfoCity(userInfo.getUserInfoCity());
        userInfoEntity.setUserInfoEducation(userInfo.getUserInfoEducation());
        userInfoEntity.setUserInfoSchool(userInfo.getUserInfoSchool());
        userInfoEntity.setUserInfoEducation(userInfo.getUserInfoEducation());
        if (userInfo.getUserInfoRole() == 2){
            Long enterpriseId = searchEnterprise(userInfo.getUserInfoEnterpriseName());
            userInfoEntity.setUserInfoEnterpriseId(enterpriseId);
        }
        boolean result = this.baseMapper.updateById(userInfoEntity) > 0;
        if (result) {
            return ResponseMessage.successMessage("修改成功");
        }
        return ResponseMessage.failedMessage("修改失败");
    }

    @Override
    public ResponseMessage uploadUserInfoAvatar(MultipartFile avatar, Long userId) {
        String fileName = createFileName(avatar,userId);
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
    @Override
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
    @Override
    public ResponseMessage deliverResume(DeliveryRecord deliveryRecord) {
        //判断deliveryRecord表中有没有存在该记录，避免重复投递
        if (existDeliveryRecord(deliveryRecord)){
            return ResponseMessage.failedMessage("您已经投递过了，请不要重复投递");
        }
        DeliveryRecordEntity deliveryRecordEntity = new DeliveryRecordEntity();
        deliveryRecordEntity.setApplicantId(deliveryRecord.getApplicantId());
        deliveryRecordEntity.setJobId(deliveryRecord.getJobId());
        deliveryRecordEntity.setDeliveryDatetime(LocalDateTime.now());
        boolean result =  deliveryRecordDao.insert(deliveryRecordEntity) > 0;
        if (result) {
            return ResponseMessage.successMessage("投递成功");
        }
        return ResponseMessage.failedMessage("投递失败");
    }

    private boolean existDeliveryRecord(DeliveryRecord deliveryRecord) {
        QueryWrapper<DeliveryRecordEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(DeliveryRecordEntity::getApplicantId,deliveryRecord.getApplicantId())
                .eq(DeliveryRecordEntity::getJobId,deliveryRecord.getJobId());
        DeliveryRecordEntity deliveryRecordEntity = deliveryRecordDao.selectOne(queryWrapper);
        return deliveryRecordEntity != null;
    }

    @Override
    public ResponseMessage getResumeReceiveRecord(Long userId) {
        List<ReceiveRecordVo> receiveRecord;
        receiveRecord = this.baseMapper.getResumeReceiveRecord(userId);
        if (receiveRecord.isEmpty()) {
            return ResponseMessage.failedMessage("没有记录!");
        }
        return ResponseMessage.successMessage(receiveRecord);
    }
    @Override
    public ResponseMessage getResumeDeliveryRecord(Long userId) {
        List<ResumeDeliveryRecordVo> resumeDeliveryRecord;
        resumeDeliveryRecord = this.baseMapper.getResumeDeliveryRecord(userId);
        if (resumeDeliveryRecord.isEmpty()) {
            return ResponseMessage.failedMessage("没有记录!");
        }
        return ResponseMessage.successMessage(resumeDeliveryRecord);
    }

    private String createFileName(MultipartFile avatar, Long userId) {
        String originalName = avatar.getOriginalFilename();
        String fileSuffix = originalName.substring(originalName.lastIndexOf(".")).toLowerCase();
        return  userId + fileSuffix;
    }

    private ResponseMessage saveFilePath(String type, String relativePath, Long userId) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserInfoId(userId);
        if (type.equals("avatar")) {
            userInfoEntity.setUserInfoAvatar(relativePath);
        }
        if (type.equals("resume")) {
            userInfoEntity.setUserInfoResume(relativePath);
        }
        boolean result = this.baseMapper.updateById(userInfoEntity) > 0;
        if (result) {
            return ResponseMessage.successMessage();
        }
        return ResponseMessage.failedMessage();
    }

    /*
    根据前端注册界面传回的用户名到user_info表里查找，
    如果不存在指定用户则返回false
    存在则返回true
    *
    */
    private boolean existUser(UserDTO user) {
        //SELECT * FROM user_info WHERE user_info.username = ?
        QueryWrapper<UserInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfoEntity::getUserInfoUsername,user.getUsername());
        UserInfoEntity userInfoEntity = this.baseMapper.selectOne(queryWrapper);
        if (userInfoEntity == null){
            return false;
        }
        System.out.println("用户已存在");
        return true;
    }
    /*
    根据前端注册界面传回的企业名称到enterprise表里查找，
    如果存在记录则返回指定id，
    否则新建记录并返回新id
    *
    */
    public Long searchEnterprise(String enterpriseName) {
        //SELECT * FROM enterprise WHERE enterprise.enterpriseName = ?
        QueryWrapper<EnterpriseEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(EnterpriseEntity::getEnterpriseName,enterpriseName);
        EnterpriseEntity enterpriseEntity = enterpriseDao.selectOne(queryWrapper);
        if (enterpriseEntity == null){
            EnterpriseEntity newEnterprise = new EnterpriseEntity();
            newEnterprise.setEnterpriseName(enterpriseName);
            enterpriseDao.insert(newEnterprise);
            return newEnterprise.getEnterpriseId();
        }
        return enterpriseEntity.getEnterpriseId();
    }

}
