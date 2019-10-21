package com.mettre.wechat_information.controller;

import com.mettre.base.Result;
import com.mettre.base.ResultUtil;
import com.mettre.wechat_information.pojo.AlarmClock;
import com.mettre.wechat_information.pojo.ClockTimeBean;
import com.mettre.wechat_information.service.AlarmClockService;
import com.mettre.wechat_information.vm.MomentsVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(description = "闹钟模块")
public class AlarmClockController {

    @Autowired
    public AlarmClockService alarmClockService;

    @RequestMapping(value = "/setAlarmClock", method = RequestMethod.POST)
    @ApiOperation(value = "设置闹钟")
    public Result<Object> insert(@Valid @RequestBody AlarmClock alarmClock) {
        alarmClockService.insert(alarmClock);
        return new ResultUtil<>().setSuccess();
    }
}
