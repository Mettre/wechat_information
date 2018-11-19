package com.mettre.wechat_information.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.pojo.News;
import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.Param;


@Component
public interface NewsMapper {
    int deleteByPrimaryKey(String newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(String newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    Page<News> selectPageVo(Page<News> page, @Param(value = "categoryId") Long categoryId);
}