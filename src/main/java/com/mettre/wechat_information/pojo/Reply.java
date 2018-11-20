package com.mettre.wechat_information.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Reply {

    private String replyId;

    private String replyParentId;

    private String dynamicId;

    private String replyParentUserId;

    private String dynamicUserId;

    private String replyContent;

    private Date creationTime;

    private Byte isShow;

    private String dynamicType;
}