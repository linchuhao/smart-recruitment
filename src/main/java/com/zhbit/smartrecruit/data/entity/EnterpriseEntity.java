package com.zhbit.smartrecruit.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("enterprise")
public class EnterpriseEntity {

    @TableId(type = IdType.AUTO)
    private Long enterpriseId;

    private String enterpriseName;

    private String enterpriseAddress;

    private String enterpriseLogo;

    private String enterpriseImg;

    private String enterpriseCity;

    private String enterpriseProperty;

    private String enterpriseIntroduction;

    private boolean enterpriseIsActive;
}
