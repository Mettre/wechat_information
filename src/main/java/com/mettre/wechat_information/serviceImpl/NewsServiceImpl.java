package com.mettre.wechat_information.serviceImpl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.enum_.DynamicTypeEnum;
import com.mettre.wechat_information.enum_.ResultEnum;
import com.mettre.wechat_information.exception.CustomerException;
import com.mettre.wechat_information.mapper.NewsMapper;
import com.mettre.wechat_information.mapper.ReadMapper;
import com.mettre.wechat_information.pojo.News;
import com.mettre.wechat_information.pojo.Read;
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

    @Autowired
    public ReadMapper readMapper;

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
    public News selectByPrimaryKey(String newsId, String readerId, String readerEquipment) {
        if (StrUtil.isBlank(newsId)) {
            throw new CustomerException(ResultEnum.NEWSIDNOTEMPTY);
        }
        News news = newsMapper.selectByPrimaryKey(newsId);
        if (news == null) {
            addReadNum(newsId, readerId, readerEquipment);
            throw new CustomerException(ResultEnum.NEWSNULL);
        }
        return news;
    }

    public void addReadNum(String newsId, String readerId, String readerEquipment) {
        Read read = null;
        if (StrUtil.isBlank(readerId) || StrUtil.isBlank(readerEquipment)) {

        } else if (StrUtil.isBlank(readerId)) {
            read = readMapper.selectByReaderIdOrEquipment(newsId, readerId, readerEquipment);

        }

        if (read == null) {

        }
        readMapper.insert(new Read(newsId, DynamicTypeEnum.NEWS, readerId, readerEquipment));
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
