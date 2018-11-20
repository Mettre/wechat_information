package com.mettre.wechat_information.mapper;

import com.mettre.wechat_information.pojo.Read;
import org.apache.ibatis.annotations.Param;
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

    Read selectByReaderIdOrEquipment(@Param(value = "dynamicId")String dynamicId, @Param(value = "readerId")String readerId, @Param(value = "readerEquipment")String readerEquipment);
}