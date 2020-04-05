package com.zhbit.smartrecruit.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryRecord {

    private Long applicantId;
    /*
    to do
    后面需要向这个hrInfoId关联的信息table发送一条消息，表示我给他投递了简历
    刚刚看了一下，我还没有建立消息表，后面做吧
     */
    private Long jobFrom;

    private Long jobId;

    private String jobName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime deliveryDatetime;
}
