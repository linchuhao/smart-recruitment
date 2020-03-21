package com.zhbit.smartrecruit.data.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReceiveRecordVo {

    private String jobName;

    private String applicantInfoName;

    private String applicantInfoResume;

    private String applicantInfoSchool;

    private String applicantInfoEducation;

    private String applicantInfoMajor;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime deliveryDatetime;
}
