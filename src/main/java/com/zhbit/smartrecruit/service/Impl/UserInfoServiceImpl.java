package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.ApplicantDao;
import com.zhbit.smartrecruit.dao.EnterpriseDao;
import com.zhbit.smartrecruit.dao.HrInfoDao;
import com.zhbit.smartrecruit.dao.UserInfoDao;
import com.zhbit.smartrecruit.data.dto.UserInfo;
import com.zhbit.smartrecruit.data.entity.ApplicantInfoEntity;
import com.zhbit.smartrecruit.data.entity.EnterpriseEntity;
import com.zhbit.smartrecruit.data.entity.HrInfoEntity;
import com.zhbit.smartrecruit.data.entity.UserInfoEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.data.vo.UserInfoVo;
import com.zhbit.smartrecruit.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

    @Resource
    ApplicantDao applicantDao;

    @Resource
    HrInfoDao hrInfoDao;

    @Resource
    EnterpriseDao enterpriseDao;

    @Override
    public ResponseMessage register(UserInfo userInfo) {
        boolean existUser = existUser(userInfo);
        if (!existUser) {
            if (1 == userInfo.getRole()) {
                applicantRegister(userInfo);
            }
            if (2 == userInfo.getRole()) {
                hrRegister(userInfo);
            }
            return ResponseMessage.successMessage(userInfo);
        }
        return ResponseMessage.failedMessage("用户已存在");
    }

    @Override
    public ResponseMessage login(UserInfo userInfo) {
        //SELECT * FROM user_info WHERE user_info.username = ? and user_info.password = ?
        QueryWrapper<UserInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfoEntity::getUserInfoUsername,userInfo.getUsername())
        .eq(UserInfoEntity::getUserInfoPassword,userInfo.getPassword());
        UserInfoEntity userInfoEntity = this.baseMapper.selectOne(queryWrapper);
        if (userInfoEntity != null) {
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setUserId(userInfoEntity.getUserInfoId());
            userInfoVo.setRole(userInfoEntity.getUserInfoRole());
            return ResponseMessage.successMessage(userInfoVo);
        }
        return ResponseMessage.failedMessage("登录失败");
    }

    /*
    根据前端注册界面传回的用户名到user_info表里查找，
    如果不存在指定用户则返回false
    存在则返回true
    *
    */
    private boolean existUser(UserInfo userInfo) {
        //SELECT * FROM user_info WHERE user_info.username = ?
        QueryWrapper<UserInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfoEntity::getUserInfoUsername,userInfo.getUsername());
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
    private Long searchEnterprise(String enterpriseName) {
        //SELECT * FROM enterprise WHERE enterprise.enterpriseName = ?
        QueryWrapper<EnterpriseEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(EnterpriseEntity::getEnterpriseName,enterpriseName);
        EnterpriseEntity enterpriseEntity = enterpriseDao.selectOne(queryWrapper);
        if (enterpriseEntity == null){
            EnterpriseEntity newEnterprise = new EnterpriseEntity();
            newEnterprise.setEnterpriseName(enterpriseName);
            newEnterprise.setEnterpriseIsActive(true);
            enterpriseDao.insert(newEnterprise);
            return newEnterprise.getEnterpriseId();
        }
        return enterpriseEntity.getEnterpriseId();
    }

    private void applicantRegister(UserInfo userInfo) {
        Long userInfoId = createUser(userInfo);
        ApplicantInfoEntity applicantInfoEntity = new ApplicantInfoEntity();
        applicantInfoEntity.setApplicantInfoId(userInfoId);
        applicantInfoEntity.setApplicantInfoName(userInfo.getUsername());
        applicantInfoEntity.setApplicantInfoPhone(userInfo.getPhone());
        applicantInfoEntity.setApplicantInfoEmail(userInfo.getEmail());
        applicantInfoEntity.setApplicantInfoIsActive(true);
        applicantDao.insert(applicantInfoEntity);
    }

    private void hrRegister(UserInfo userInfo) {
        Long userInfoId = createUser(userInfo);
        HrInfoEntity hrInfoEntity = new HrInfoEntity();
        if (StringUtils.isNotEmpty(userInfo.getEnterpriseName())) {
            Long enterpriseId = searchEnterprise(userInfo.getEnterpriseName());
            hrInfoEntity.setHrInfoEnterpriseId(enterpriseId);
        }
        hrInfoEntity.setHrInfoId(userInfoId);
        hrInfoEntity.setHrInfoName(userInfo.getUsername());
        hrInfoEntity.setHrInfoPhone(userInfo.getPhone());
        hrInfoEntity.setHrInfoEmail(userInfo.getEmail());
        hrInfoEntity.setHrInfoIsActive(true);
        hrInfoDao.insert(hrInfoEntity);
    }

    private Long createUser(UserInfo userInfo) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserInfoUsername(userInfo.getUsername());
        userInfoEntity.setUserInfoPassword(userInfo.getPassword());
        userInfoEntity.setUserInfoRole(userInfo.getRole());
        userInfoEntity.setUserInfoIsActive(true);
        this.baseMapper.insert(userInfoEntity);
        return userInfoEntity.getUserInfoId();
    }

}
