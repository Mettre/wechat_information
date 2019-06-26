package com.mettre.wechat_information.feign;

import com.mettre.account.pojoVM.VisitorRpcVM;
import com.mettre.account.pojoVM.VisitorVM;
import com.mettre.wechat_information.base.Result;
import com.mettre.wechat_information.dto.UserDto;
import org.apache.ibatis.jdbc.Null;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient("account")
@RestController
public interface UserClient {

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    Result<UserDto> findUserInfo(@RequestParam("userId") String userId);


    @RequestMapping(value = "/rpc/addVisitor", method = RequestMethod.POST)
    Result<Object> addVisitor(@Valid @RequestBody VisitorRpcVM visitorVM);
}
