package com.mettre.wechat_information.controller;

import com.mettre.wechat_information.service.ReadService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(description = "阅读量")
public class ReadController {

    @Autowired
    public ReadService readService;


}
