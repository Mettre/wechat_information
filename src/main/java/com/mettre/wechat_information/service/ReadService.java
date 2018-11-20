package com.mettre.wechat_information.service;

import com.mettre.wechat_information.pojo.Read;

public interface ReadService {

    int deleteByPrimaryKey(String readId);

    int insert(Read record);

    int insertSelective(Read record);

    Read selectByPrimaryKey(String readId);

    int updateByPrimaryKeySelective(Read record);

    int updateByPrimaryKey(Read record);
}
