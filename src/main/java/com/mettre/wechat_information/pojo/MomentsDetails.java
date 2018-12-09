package com.mettre.wechat_information.pojo;

import lombok.Data;

import java.util.List;

/**
 * 说说详情
 */
@Data
public class MomentsDetails {

    private String momentsId;

    private Moments moments;

    private List<Reply> reply;
}
