package com.mettre.wechat_information.serviceImpl;

import com.mettre.wechat_information.enum_.DynamicTypeEnum;
import com.mettre.wechat_information.enum_.FrequencyEnum;
import com.mettre.wechat_information.enum_.ResultEnum;
import com.mettre.wechat_information.exception.CustomerException;
import com.mettre.wechat_information.mapper.AlarmClockMapper;
import com.mettre.wechat_information.pojo.AlarmClock;
import com.mettre.wechat_information.pojo.ClockTimeBean;
import com.mettre.wechat_information.service.AlarmClockService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlarmClockServiceImpl implements AlarmClockService {

    @Autowired
    public AlarmClockMapper alarmClockMapper;

    @Override
    public int deleteByPrimaryKey(String clockId) {
        return 0;
    }

    @Override
    public int insert(AlarmClock alarmClock) {

        if (!FrequencyEnum.contains(alarmClock.getFrequency().name())) {
            throw new CustomerException("闹钟类型不能为空");
        }
        if (alarmClock.getFrequency() == FrequencyEnum.CUSTOM) {
            if (TextUtils.isEmpty(alarmClock.getCustomDay())) {
                throw new CustomerException("自定义日期不能为空");
            }
        } else {
            alarmClock.setCustomDay("");
        }

        return alarmClockMapper.insert(new AlarmClock(alarmClock));
    }

    @Override
    public int insertSelective(AlarmClock record) {
        return 0;
    }

    @Override
    public AlarmClock selectByPrimaryKey(String clockId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(AlarmClock record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(AlarmClock record) {
        return 0;
    }
}
