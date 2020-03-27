package com.zhbit.smartrecruit.data.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobReleaseRecordVo {

    public Long jobId;

    public Long jobFrom;

    public String jobName;

    public String jobProperty;

    public int jobMinSalary;

    public int jobMaxSalary;

    public String jobEducation;

    public String jobExperience;

    public String jobCity;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public LocalDateTime jobDatetime;

    public String jobRequirement;

    public int deliveryCount;

}