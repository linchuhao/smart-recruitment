package com.zhbit.smartrecruit.data.dto;

import lombok.Data;
/**
 * @model User
 * @description 用户对象
 * @field userId 用户id
 * @field username 用户名
 * @field password 密码
 * @field company 关联的公司
 * @field phone 手机号
 * @field email 邮箱
 * @field role 角色，1为求职者，2为hr, 3为系统管理员
 **/
@Data
public class UserDTO {
    private Long userId;
    /*
    applicant :1
    hr: 2
    admin: 3
     */
    private Integer role;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String enterpriseName;
}
