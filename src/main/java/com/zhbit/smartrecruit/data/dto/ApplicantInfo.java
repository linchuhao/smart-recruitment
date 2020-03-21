package com.zhbit.smartrecruit.data.dto;

import lombok.Data;

@Data
public class ApplicantInfo {
    private Long applicantInfoId;

    private String applicantInfoName;

    private String applicantInfoPhone;

    private String applicantInfoEmail;

    private String applicantInfoAddress;

    private String applicantInfoSchool;

    /*
      大专
      本科
      硕士
    */
    private String applicantInfoEducation;

    private String applicantInfoSalary;

    private String applicantInfoSex;

    private String applicantInfoImg;
    //专业
    private String applicantInfoMajor;
    //职位
    private String applicantInfoProperty;

    private String applicantInfoResume;

    private String applicantInfoIntroduction;
}
