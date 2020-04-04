package com.zhbit.smartrecruit.data.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserMsgVo {

    private Long userMsgId;

    private Long userMsgFrom;

    private String enterpriseName;

    private String sender;

    private String userMsgTitle;

    private String userMsgContent;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime userMsgSendDatetime;

    private boolean userMsgStatus;

}
