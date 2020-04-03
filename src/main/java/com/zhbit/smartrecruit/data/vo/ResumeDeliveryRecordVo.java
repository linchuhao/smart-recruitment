package com.zhbit.smartrecruit.data.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResumeDeliveryRecordVo {

    private Long jobId;

    private String enterpriseName;

    private String jobName;

    private String jobType;

    private int jobMinSalary;

    private int jobMaxSalary;

    private String jobCity;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime deliveryDatetime;
}
