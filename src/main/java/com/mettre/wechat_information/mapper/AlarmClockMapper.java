package com.mettre.wechat_information.mapper;

import com.mettre.wechat_information.pojo.AlarmClock;
import org.springframework.stereotype.Component;

@Component
public interface AlarmClockMapper {
    int deleteByPrimaryKey(String clockId);

    int insert(AlarmClock record);

    int insertSelective(AlarmClock record);

    AlarmClock selectByPrimaryKey(String clockId);

    int updateByPrimaryKeySelective(AlarmClock record);

    int updateByPrimaryKey(AlarmClock record);
}