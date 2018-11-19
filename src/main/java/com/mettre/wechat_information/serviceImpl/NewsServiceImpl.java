package com.mettre.wechat_information.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.mapper.NewsMapper;
import com.mettre.wechat_information.pojo.News;
import com.mettre.wechat_information.service.NewsService;
import com.mettre.wechat_information.vm.NewsVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    public NewsMapper newsMapper;


    @Override
    public int deleteByPrimaryKey(String newsId) {
        return 0;
    }

    @Override
    public int insert(NewsVM newsVM) {
        News news = new News(newsVM);
        return newsMapper.insert(news);
    }

    @Override
    public int insertSelective(News record) {
        return 0;
    }

    @Override
    public News selectByPrimaryKey(String newsId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(News record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(News record) {
        return 0;
    }

    @Override
    public Page<News> selectPageVo(Page<News> page, Long categoryId) {
        List<News> addressList = (List<News>) newsMapper.selectPageVo(page, categoryId);
        page = page.setRecords(addressList);
        return page;
    }
}
