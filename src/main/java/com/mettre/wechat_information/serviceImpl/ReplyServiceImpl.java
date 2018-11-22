package com.mettre.wechat_information.serviceImpl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.enum_.DynamicTypeEnum;
import com.mettre.wechat_information.enum_.ResultEnum;
import com.mettre.wechat_information.exception.CustomerException;
import com.mettre.wechat_information.mapper.ReplyMapper;
import com.mettre.wechat_information.pojo.Reply;
import com.mettre.wechat_information.service.NewsService;
import com.mettre.wechat_information.service.ReplyService;
import com.mettre.wechat_information.vm.ReplyVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

    private static final Logger logger = LoggerFactory.getLogger(ReplyServiceImpl.class);


    @Autowired
    public ReplyMapper replyMapper;

    @Autowired
    public NewsService newsService;

    @Override
    public int deleteByPrimaryKey(String replyId) {
        return 0;
    }

    @Override
    public int insert(ReplyVM replyVM) {

        if (!DynamicTypeEnum.contains(replyVM.getDynamicType().name())) {
            throw new CustomerException(ResultEnum.DYNAMICTYPE);
        }
        switch (replyVM.getDynamicType()) {
            case NEWS:
                newsService.selectByPrimaryKey(replyVM.getDynamicId(), null, null);
                if (StrUtil.isNotBlank(replyVM.getReplyParentId())) {
                    Reply reply = replyMapper.selectByPrimaryKey(replyVM.getReplyParentId());
                    if (reply == null) {
                        throw new CustomerException(ResultEnum.COMMENTARYDELETING);
                    } else {
                        if (StrUtil.isNotBlank(reply.getSecondDynamicId())) {
                            return replyMapper.insert(new Reply(replyVM, reply.getReplyId(), reply.getDynamicUserId(), reply.getSecondDynamicId()));
                        } else {
                            return replyMapper.insert(new Reply(replyVM, reply.getReplyId(), reply.getDynamicUserId(), reply.getReplyId()));
                        }
                    }
                } else {
                    return replyMapper.insert(new Reply(replyVM));
                }

            case MOMENTS:
                return replyMapper.insert(new Reply(replyVM));

            case FORUM:
                return replyMapper.insert(new Reply(replyVM));

            default:
                return replyMapper.insert(new Reply(replyVM));

        }

    }

    @Override
    public int insertSelective(Reply record) {
        return 0;
    }

    @Override
    public Reply selectByPrimaryKey(String replyId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Reply record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Reply record) {
        return 0;
    }

    @Override
    public Page<Reply> selectPageVo(Page<Reply> page, String dynamicId) {
        List<Reply> addressList = (List<Reply>) replyMapper.selectPageVo(page, dynamicId);
        page = page.setRecords(addressList);
        return page;
    }
}
