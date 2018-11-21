package com.mettre.wechat_information.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.enum_.DynamicTypeEnum;
import com.mettre.wechat_information.pojo.Reply;
import com.mettre.wechat_information.vm.ReplyVM;

public interface ReplyService {

    int deleteByPrimaryKey(String replyId);

    int insert(ReplyVM replyVM);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(String replyId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    Page<Reply> selectPageVo(Page<Reply> page, String dynamicId);
}
