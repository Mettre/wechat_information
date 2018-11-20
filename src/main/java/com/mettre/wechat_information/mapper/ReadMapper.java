package com.mettre.wechat_information.mapper;

import com.mettre.wechat_information.pojo.Read;
import org.springframework.stereotype.Component;

/**
 * 阅读量
 */
@Component
public interface ReadMapper {

    int deleteByPrimaryKey(String readId);

    int insert(Read record);

    int insertSelective(Read record);

    Read selectByPrimaryKey(String readId);

    int updateByPrimaryKeySelective(Read record);

    int updateByPrimaryKey(Read record);

    Read selectByReaderIdOrEquipment(String newsId,String readId, String readerEquipment);
}