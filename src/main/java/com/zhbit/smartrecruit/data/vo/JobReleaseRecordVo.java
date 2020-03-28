package com.zhbit.smartrecruit.data.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobReleaseRecordVo {

    private Long jobId;

    private String jobFrom;

    private String enterpriseName;

    private String enterpriseLogo;

    private String jobName;

    private String jobProperty;

    private int jobMinSalary;

    private int jobMaxSalary;

    private String jobEducation;

    private String jobExperience;

    private String jobCity;

    private String jobAddress;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime jobDatetime;

    private String jobResponsibility;

    private String jobRequirement;

    private int deliveryCount;

}
