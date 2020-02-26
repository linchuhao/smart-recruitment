package com.zhbit.smartrecruit.data.dto;

import lombok.Data;

@Data
public class Result<T> {
    //返回信息
    private String msg;
    //数据是否正常请求
    private boolean success;
    //具体返回的数据
    private T detail;
    //... getter and setter

}