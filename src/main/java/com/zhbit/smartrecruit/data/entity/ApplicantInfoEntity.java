package com.zhbit.smartrecruit.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("applicant_info")
public class ApplicantInfoEntity {

    @TableId(type = IdType.NONE)
    private Long applicantInfoId;

    private Long applicantInfoEnterpriseId;

    private String applicantInfoName;

    private String applicantInfoPhone;

    private String applicantInfoEmail;

    private String applicantInfoAddress;

    private String applicantInfoSchool;

    /*
      大专
      本科
      研究生
    */
    private String applicantInfoEducation;

    private String applicantInfoSalary;

    private String applicantInfoSex;

    private String applicantInfoAge;

    private String applicantInfoImg;

    private String applicantInfoCity;

    private String applicantInfoProperty;

    private String applicantInfoResume;

    private boolean applicantInfoIsActive;

}
