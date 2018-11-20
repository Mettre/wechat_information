package com.mettre.wechat_information.serviceImpl;

import com.mettre.wechat_information.mapper.ReadMapper;
import com.mettre.wechat_information.pojo.Read;
import com.mettre.wechat_information.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReadServiceImpl implements ReadService {

    @Autowired
    public ReadMapper readMapper;

    @Override
    public int deleteByPrimaryKey(String readId) {
        return 0;
    }

    @Override
    public int insert(Read record) {
        return 0;
    }

    @Override
    public int insertSelective(Read record) {
        return 0;
    }

    @Override
    public Read selectByPrimaryKey(String readId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Read record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Read record) {
        return 0;
    }
}
