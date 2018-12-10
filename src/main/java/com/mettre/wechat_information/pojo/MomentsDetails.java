package com.mettre.wechat_information.pojo;

import com.mettre.wechat_information.pojo.entity.MomentsParameter;
import lombok.Data;

import java.util.List;

/**
 * 说说详情
 */
@Data
public class MomentsDetails {

    private String momentsId;

    private MomentsParameter moments;

    private List<Reply> replyList;
}
