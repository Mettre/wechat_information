package com.mettre.wechat_information.feign;

import com.mettre.wechat_information.base.Result;
import com.mettre.wechat_information.dto.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("account")
@RestController
public interface UserClient {

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    Result<UserDto> findUserInfo(@RequestParam("userId") String userId);
}
