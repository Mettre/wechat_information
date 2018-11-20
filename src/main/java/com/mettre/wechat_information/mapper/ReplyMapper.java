package com.mettre.wechat_information.mapper;

import com.mettre.wechat_information.pojo.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(String replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(String replyId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}