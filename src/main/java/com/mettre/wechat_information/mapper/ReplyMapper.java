package com.mettre.wechat_information.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.pojo.Reply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 评论
 */
@Component
public interface ReplyMapper {
    int deleteByPrimaryKey(String replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(String replyId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    List<Reply> selectPageVo(Page<Reply> page, @Param(value = "dynamicId") String dynamicId);

    List<Reply> selectMomentsReply(@Param(value = "dynamicId") String dynamicId);

    List<Reply> selectSecondMoments(@Param(value = "secondDynamicId") String secondDynamicId);

}