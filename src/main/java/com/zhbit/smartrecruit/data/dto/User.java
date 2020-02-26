package com.zhbit.smartrecruit.data.dto;

import lombok.Data;
/**
 * @model User
 * @description 用户对象
 * @field userId 用户id
 * @field nickname 昵称
 * @field username 用户名
 * @field password 密码
 * @field company 关联的公司
 * @field phone 手机号
 * @field email 邮箱
 * @field role 角色，1为hr，2为求职者, 3为系统管理员
 **/
@Data
public class User {
    private Long userId;
    //用户名
    private String username;
    private String password;
    private String company;
    private String email;
    private String phone;
    private int role;
    private int active;
}
