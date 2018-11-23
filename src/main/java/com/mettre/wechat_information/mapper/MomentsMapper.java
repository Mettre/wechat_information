package com.mettre.wechat_information.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.pojo.Moments;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MomentsMapper {

    int deleteByPrimaryKey(String momentsId);

    int insert(Moments record);

    int insertSelective(Moments record);

    Moments selectByPrimaryKey(String momentsId);

    int updateByPrimaryKeySelective(Moments record);

    int updateByPrimaryKey(Moments record);

    List<Moments> selectPageVo(Page<Moments> page, @Param(value = "publisherUserId") String publisherUserId);
}