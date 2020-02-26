package com.zhbit.smartrecruit.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("hr_info")
public class HrInfoEntity {

    @TableId(type = IdType.NONE)
    private Long hrInfoId;

    private Long hrInfoEnterpriseId;

    private String hrInfoName;

    private String hrInfoPhone;

    private String hrInfoEmail;

    private String hrInfoSchool;

    private String hrInfoEducation;

    private String hrInfoSex;

    private String hrInfoAge;

    private String hrInfoImg;

    private String hrInfoCity;

    private String hrInfoIntroduction;

    private boolean hrInfoIsActive;
}
