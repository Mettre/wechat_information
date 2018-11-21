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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

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

        if (!DynamicTypeEnum.contains(replyVM.getDynamicType().dynamicType)) {
            throw new CustomerException(ResultEnum.DYNAMICTYPE);
        }
        newsService.selectByPrimaryKey(replyVM.getDynamicId(), null, null);
        if (StrUtil.isNotBlank(replyVM.getReplyParentId())) {
            Reply reply = replyMapper.selectByPrimaryKey(replyVM.getReplyParentId());
            if (reply == null) {
                throw new CustomerException(ResultEnum.COMMENTARYDELETING);
            } else {
                return replyMapper.insert(new Reply(replyVM, reply.getReplyId(), reply.getDynamicUserId()));
            }
        } else {
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
    public Page<Reply> selectPageVo(Page<Reply> page, String dynamicId, DynamicTypeEnum dynamicTypeEnum) {
        List<Reply> addressList = (List<Reply>) replyMapper.selectPageVo(page, dynamicId, dynamicTypeEnum);
        page = page.setRecords(addressList);
        return page;
    }
}
