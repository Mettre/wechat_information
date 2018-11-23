package com.mettre.wechat_information.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.pojo.Moments;
import com.mettre.wechat_information.vm.MomentsVM;

public interface MomentsService {

    int deleteByPrimaryKey(String momentsId);

    int insert(MomentsVM record);

    int insertSelective(Moments record);

    Moments selectByPrimaryKey(String momentsId);

    int updateByPrimaryKeySelective(Moments record);

    int updateByPrimaryKey(Moments record);

    Page<Moments> selectPageVo(Page<Moments> page, String publisherUserId);
}
