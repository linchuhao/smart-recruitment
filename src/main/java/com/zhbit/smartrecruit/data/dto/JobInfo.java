package com.zhbit.smartrecruit.data.dto;

import lombok.Data;


@Data
public class JobInfo {

    private Long jobId;

    private Long jobFrom;

    private String jobName;

    private String jobProperty;

    private String jobResponsibility;

    private int jobMinSalary;

    private int jobMaxSalary;

    private String jobEducation;

    private String jobExperience;

    private String jobCity;

    private String jobAddress;

    private String jobRequirement;

}
