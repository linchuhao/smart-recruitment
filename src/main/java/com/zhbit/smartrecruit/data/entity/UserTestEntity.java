package com.zhbit.smartrecruit.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_test")//@TableName中的值对应着表名
public class UserTestEntity {
    @TableId(type = IdType.AUTO)
    private Long userId;
    private String username;
    private String password;
    private String company;
    private String email;
    private String phone;
    private int role;
    private String sex;
    private String school;
    private String level;//针对HR而言
    private String job;
    private String resume;
    private String avatar;
    private int active;
}
