package com.mettre.wechat_information.service;

import com.mettre.wechat_information.pojo.AlarmClock;

public interface AlarmClockService {

    int deleteByPrimaryKey(String clockId);

    int insert(AlarmClock alarmClock);

    int insertSelective(AlarmClock record);

    AlarmClock selectByPrimaryKey(String clockId);

    int updateByPrimaryKeySelective(AlarmClock record);

    int updateByPrimaryKey(AlarmClock record);
}
