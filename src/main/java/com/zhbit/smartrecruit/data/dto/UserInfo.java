package com.zhbit.smartrecruit.data.dto;

import lombok.Data;

@Data
public class UserInfo {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String enterpriseName;
    /*
    userInfoRole
    1: applyer
    2: HR
    3: admin

    */
    private Integer role;

}
