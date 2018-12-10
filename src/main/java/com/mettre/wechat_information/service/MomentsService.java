package com.mettre.wechat_information.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.pojo.Moments;
import com.mettre.wechat_information.pojo.MomentsDetails;
import com.mettre.wechat_information.pojo.entity.MomentsParameter;
import com.mettre.wechat_information.vm.MomentsVM;

public interface MomentsService {

    int deleteByPrimaryKey(String momentsId);

    int insert(MomentsVM record);

    int insertSelective(Moments record);

    Moments selectByPrimaryKey(String momentsId);

    int updateByPrimaryKeySelective(Moments record);

    int updateByPrimaryKey(Moments record);

    Page<MomentsParameter> selectPageVo(Page<MomentsParameter> page, String publisherUserId);

    Page<MomentsParameter> circleFriendsPageVo(Page<MomentsParameter> page, String userId);

    MomentsDetails selectMomentsDetails(String momentsId);
}
