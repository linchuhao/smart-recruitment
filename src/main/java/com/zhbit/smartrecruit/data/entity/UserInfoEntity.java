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
    1: applyer
    2: HR
    3: admin

    */
    private Integer userInfoRole;

    private boolean userInfoIsActive;
}
