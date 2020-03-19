package com.zhbit.smartrecruit.data.dto;

import lombok.Data;

@Data
public class HrInfo {

    private Long hrInfoId;

    private Long hrInfoEnterpriseId;

    private String hrInfoProperty;

    private String hrInfoEnterpriseName;

    private String hrInfoName;

    private String hrInfoPhone;

    private String hrInfoEmail;

    private String hrInfoSchool;
    /*
      大专
      本科
      硕士
    */
    private String hrInfoEducation;

    private String hrInfoSex;

    private String hrInfoImg;

    private String hrInfoIntroduction;

}
