package com.mettre.wechat_information.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.base.Result;
import com.mettre.dto.UserDto;
import com.mettre.enum_.ResultEnum;
import com.mettre.exception.CustomerException;
//import com.mettre.feign.UserClient;
import com.mettre.jwt.SecurityContextStore;
import com.mettre.vm.VisitorRpcVM;
import com.mettre.wechat_information.feign.UserClient;
import com.mettre.wechat_information.mapper.MomentsMapper;
import com.mettre.wechat_information.pojo.Moments;
import com.mettre.wechat_information.pojo.MomentsDetails;
import com.mettre.wechat_information.pojo.entity.MomentsParameter;
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
        String userId = SecurityContextStore.getContext().getUserId();
        Result<UserDto> userDtoResult = userClient.findUserInfo(userId);
        if (userDtoResult.getData() == null) {
            throw new CustomerException(ResultEnum.USEREMPTY);
        }
        return momentsMapper.insert(new Moments(momentsVM, userId));
    }

    @Override
    public int insertSelective(Moments record) {
        return 0;
    }

    @Override
    public MomentsParameter selectByPrimaryKey(String momentsId) {
        MomentsParameter momentsParameter = momentsMapper.selectByPrimaryKey(momentsId);
        if (momentsParameter == null) {
            throw new CustomerException("该条动态不存在");
        }
        return momentsParameter;
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
    public Page<MomentsParameter> selectPageVo(Page<MomentsParameter> page, String publisherUserId) {
        String userId = SecurityContextStore.getContext().getUserId();
        if (!userId.equals(publisherUserId)) {
            VisitorRpcVM visitorVM = new VisitorRpcVM();
            visitorVM.setUserId(userId);
            visitorVM.setVisitorsUser(publisherUserId);
            Result<Object> s = userClient.addVisitor(visitorVM);
            System.out.println(s.toString());
        }
        List<MomentsParameter> momentsList = (List<MomentsParameter>) momentsMapper.selectPageVo(page, publisherUserId);
        page = page.setRecords(momentsList);
        return page;
    }

    @Override
    public Page<MomentsParameter> circleFriendsPageVo(Page<MomentsParameter> page, String userId) {
        List<MomentsParameter> momentsList = (List<MomentsParameter>) momentsMapper.circleFriendsPageVo(page, userId);
        page = page.setRecords(momentsList);
        return page;
    }

    @Override
    public MomentsDetails selectMomentsDetails(String momentsId) {
        return momentsMapper.selectMomentsDetails(momentsId);
    }
}
