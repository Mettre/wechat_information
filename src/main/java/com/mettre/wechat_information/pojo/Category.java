package com.mettre.wechat_information.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Long categoryId;

    private String categoryName;

    private Date updateTime;

    private Date creationTime;

    private Byte isShow;
}