package com.mettre.wechat_information.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.base.Result;
import com.mettre.wechat_information.base.ResultUtil;
import com.mettre.wechat_information.pojo.MomentsDetails;
import com.mettre.wechat_information.pojo.entity.MomentsParameter;
import com.mettre.wechat_information.service.MomentsService;
import com.mettre.wechat_information.vm.MomentsListVM;
import com.mettre.wechat_information.vm.MomentsVM;
import com.mettre.wechat_information.vm.PersonalMomentsListVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(description = "朋友圈模块")
public class MomentsController {

    @Autowired
    public MomentsService momentsService;

    @RequestMapping(value = "/addMoments", method = RequestMethod.POST)
    @ApiOperation(value = "发布说说")
    public Result<Object> insert(@Valid @RequestBody MomentsVM momentsVM) {
        momentsService.insert(momentsVM);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/findMomentsListWithPublisherUserId", method = RequestMethod.POST)
    @ApiOperation(value = "查询个人发布的说说")
    public Result<Object> findCategoryList(@Valid @RequestBody PersonalMomentsListVM pageUtil) {

        Page<MomentsParameter> page2 = new Page<>(pageUtil.getPage(), pageUtil.getSize());
        Page<MomentsParameter> momentsList = momentsService.selectPageVo(page2, pageUtil.getPublisherUserId());
        return new ResultUtil<>().setData(momentsList);
    }

    @RequestMapping(value = "/circleFriendsList", method = RequestMethod.POST)
    @ApiOperation(value = "我的朋友圈们")
    public Result<Object> circleFriendsList(@Valid @RequestBody MomentsListVM pageUtil) {

        Page<MomentsParameter> page = new Page<>(pageUtil.getPage(), pageUtil.getSize());
        Page<MomentsParameter> momentsList = momentsService.circleFriendsPageVo(page, pageUtil.getUserId());
        return new ResultUtil<>().setData(momentsList);
    }


    @RequestMapping(value = "/selectMomentsDetails", method = RequestMethod.POST)
    @ApiOperation(value = "说说详情+评论")
    public Result<Object> selectMomentsDetails(@RequestParam String momentsId) {
        MomentsDetails momentsDetails = momentsService.selectMomentsDetails(momentsId);
        return new ResultUtil<>().setData(momentsDetails);
    }

}
