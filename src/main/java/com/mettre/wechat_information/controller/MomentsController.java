package com.mettre.wechat_information.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.wechat_information.base.Result;
import com.mettre.wechat_information.base.ResultUtil;
import com.mettre.wechat_information.pojo.Moments;
import com.mettre.wechat_information.service.MomentsService;
import com.mettre.wechat_information.vm.MomentsVM;
import com.mettre.wechat_information.vm.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(description = "说说模块")
public class MomentsController {

    @Autowired
    public MomentsService momentsService;

    @RequestMapping(value = "/addMoments", method = RequestMethod.POST)
    @ApiOperation(value = "发布说说")
    public Result<Object> insert(@Valid @RequestBody MomentsVM momentsVM) {
        momentsService.insert(momentsVM);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/findMomentsList", method = RequestMethod.POST)
    @ApiOperation(value = "我发布的说说")
    public Result<Object> findCategoryList(@Valid @RequestBody PageUtil pageUtil, @RequestParam String publisherUserId) {

        Page<Moments> page2 = new Page<>(pageUtil.getPage(), pageUtil.getSize());
        Page<Moments> momentsList = momentsService.selectPageVo(page2, publisherUserId);
        return new ResultUtil<>().setData(momentsList);
    }

    @RequestMapping(value = "/circleFriendsList", method = RequestMethod.POST)
    @ApiOperation(value = "我的朋友圈们")
    public Result<Object> circleFriendsList(@Valid @RequestBody PageUtil pageUtil, @RequestParam String userId) {

        Page<Moments> page2 = new Page<>(pageUtil.getPage(), pageUtil.getSize());
        Page<Moments> momentsList = momentsService.circleFriendsPageVo(page2, userId);
        return new ResultUtil<>().setData(momentsList);
    }

}
