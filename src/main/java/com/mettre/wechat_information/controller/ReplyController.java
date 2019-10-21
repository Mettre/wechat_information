package com.mettre.wechat_information.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mettre.base.Result;
import com.mettre.base.ResultUtil;
import com.mettre.jwt.SecurityContextStore;
import com.mettre.wechat_information.pojo.Reply;
import com.mettre.wechat_information.service.ReplyService;
import com.mettre.wechat_information.vm.DeleteReplyMomentsVM;
import com.mettre.wechat_information.vm.ReplyVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@Api(description = "评论")
public class ReplyController {

    @Autowired
    public ReplyService replyService;

    @RequestMapping(value = "/loginEd/addReply", method = RequestMethod.POST)
    @ApiOperation(value = "添加评论")
    public Result<Object> insert(@Valid @RequestBody ReplyVM replyVM) {
        replyService.insert(replyVM);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/findNewsReplyList", method = RequestMethod.POST)
    @ApiOperation(value = "新闻评论列表")
    public Result<Object> findCategoryList(@RequestBody HashMap<String, Object> map) {
        Integer page = Integer.parseInt(map.get("page").toString());
        Integer size = Integer.parseInt(map.get("size").toString());
        String dynamicId = map.get("dynamicId").toString();
        String userId = map.get("userId").toString();
        Page<Reply> page2 = new Page<>(page, size);
        Page<Reply> addressList = replyService.selectPageVo(page2, dynamicId, userId);
        return new ResultUtil<>().setData(addressList);
    }

    @RequestMapping(value = "/findMomentsReplyList", method = RequestMethod.GET)
    @ApiOperation(value = "朋友圈评论列表")
    public Result<Object> findMomentsCategoryList(@RequestParam String dynamicId, String userId) {
        List<Reply> replyList = replyService.selectMomentsReply(dynamicId, userId);
        return new ResultUtil<>().setData(replyList);
    }

    @RequestMapping(value = "/loginEd/deleteReplyFromUser{replyId}", method = RequestMethod.GET)
    @ApiOperation(value = "用户删除评论")
    public Result<Object> deleteReplyFromUser(@PathVariable String replyId) {
        String userId = SecurityContextStore.getContext().getUserId();
        replyService.deleteByReplyIdAndDynamicUserId(replyId, userId);
        return new ResultUtil<>().setSuccess();
    }

    @RequestMapping(value = "/loginEd/deleteReply{replyId}", method = RequestMethod.GET)
    @ApiOperation(value = "删除评论")
    public Result<Object> deleteReply(@PathVariable String replyId) {
        replyService.deleteByPrimaryKey(replyId);
        return new ResultUtil<>().setSuccess();
    }

}
