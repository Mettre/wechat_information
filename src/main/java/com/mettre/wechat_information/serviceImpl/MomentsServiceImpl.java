package com.mettre.wechat_information.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.base.Result;
import com.mettre.wechat_information.dto.UserDto;
import com.mettre.wechat_information.enum_.ResultEnum;
import com.mettre.wechat_information.exception.CustomerException;
import com.mettre.wechat_information.feign.UserClient;
import com.mettre.wechat_information.mapper.MomentsMapper;
import com.mettre.wechat_information.pojo.Moments;
import com.mettre.wechat_information.service.MomentsService;
import com.mettre.wechat_information.vm.MomentsVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MomentsServiceImpl implements MomentsService {

    @Autowired
    public UserClient userClient;

    @Autowired
    public MomentsMapper momentsMapper;

    @Override
    public int deleteByPrimaryKey(String momentsId) {
        return 0;
    }

    @Override
    public int insert(MomentsVM momentsVM) {
        Result<UserDto> userDtoResult = userClient.findUserInfo(momentsVM.getPublisherUserId());
        if (userDtoResult.getData() == null) {
            throw new CustomerException(ResultEnum.USEREMPTY);
        }
        return momentsMapper.insert(new Moments(momentsVM));
    }

    @Override
    public int insertSelective(Moments record) {
        return 0;
    }

    @Override
    public Moments selectByPrimaryKey(String momentsId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Moments record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Moments record) {
        return 0;
    }

    @Override
    public Page<Moments> selectPageVo(Page<Moments> page, String publisherUserId) {
        List<Moments> momentsList = (List<Moments>) momentsMapper.selectPageVo(page, publisherUserId);
        page = page.setRecords(momentsList);
        return page;
    }
}
