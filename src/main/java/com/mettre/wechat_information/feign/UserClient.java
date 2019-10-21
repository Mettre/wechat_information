package com.mettre.wechat_information.feign;

import com.mettre.base.Result;
import com.mettre.dto.UserDto;
import com.mettre.vm.VisitorRpcVM;
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
