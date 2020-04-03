package com.zhbit.smartrecruit.data.dto;

import lombok.Data;

@Data
public class UserInfoDTO {
    private Long userInfoId;
    /*
    userInfoRole
    1: applicant
    2: HR
    3: admin

    */
    private Integer userInfoRole;

    private String userInfoNickname;

    private String userInfoEnterpriseName;
    //职务
    private String userInfoPosition;

    private String userInfoPhone;

    private String userInfoEmail;

    private String userInfoSchool;

    private String userInfoEducation;

    private String userInfoSex;

    private int userInfoAge;

    private String userInfoAvatar;

    private String userInfoCity;

    private String userInfoIntroduction;

    private String userInfoResume;

}
