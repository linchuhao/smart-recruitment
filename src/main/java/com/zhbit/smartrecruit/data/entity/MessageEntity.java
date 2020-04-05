package com.zhbit.smartrecruit.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("Message")
public class MessageEntity {
    @TableId(type = IdType.AUTO)
    private Long MessageId;

    private Long MessageFrom;

    private Long MessageTo;

    private String MessageTitle;

    private String MessageContent;

    private String MessageAnnex;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime MessageCreateDatetime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime MessageReadDatetime;

    private boolean MessageStatus;

    private boolean MessageIsActive;
}
