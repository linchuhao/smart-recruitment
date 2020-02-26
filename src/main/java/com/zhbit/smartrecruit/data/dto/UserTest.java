package com.zhbit.smartrecruit.data.dto;

import lombok.Data;

@Data
public class UserTest {
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
}
