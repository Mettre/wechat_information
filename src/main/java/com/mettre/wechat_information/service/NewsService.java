package com.mettre.wechat_information.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.pojo.News;
import com.mettre.wechat_information.vm.NewsVM;

public interface NewsService {

    int deleteByPrimaryKey(String newsId);

    int insert(NewsVM newsVM);

    int insertSelective(News record);

    News selectByPrimaryKey(String newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    Page<News> selectPageVo(Page<News> page, Long categoryId);
}
