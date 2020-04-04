package com.zhbit.smartrecruit.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_info")
public class UserInfoEntity {

    @TableId(type = IdType.AUTO)
    private Long userInfoId;

    private String userInfoUsername;

    private String userInfoPassword;
    /*
    userInfoRole
    1: applicant
    2: HR
    3: admin

    */
    private Integer userInfoRole;

    private String userInfoNickname;

    private Long userInfoEnterpriseId;
    //职务
    private String userInfoPosition;

    private String userInfoPhone;

    private String userInfoEmail;

    private String userInfoSchool;

    private String userInfoMajor;

    private String userInfoEducation;

    private String userInfoSex;

    private int userInfoAge;

    private String userInfoAvatar;

    private String userInfoCity;

    private String userInfoIntroduction;

    private String userInfoResume;

    private boolean userInfoIsActive;
}
