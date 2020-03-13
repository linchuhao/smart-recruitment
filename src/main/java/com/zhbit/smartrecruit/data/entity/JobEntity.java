package com.zhbit.smartrecruit.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("job")
public class JobEntity {
    @TableId(type = IdType.AUTO)
    private Long jobId;

    private String jobName;

    private String jobFrom;

    private String jobSalary;

    private String jobAddress;

    private String jobImg;

    private String jobCity;

    private String jobProperty;

    private String jobRequirement;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime jobDatetime;

    private boolean jobIsHot;

    private boolean jobIsActive;
}