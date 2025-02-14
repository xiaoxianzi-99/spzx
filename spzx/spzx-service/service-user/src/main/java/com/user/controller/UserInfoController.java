package com.user.controller;

import com.model.dto.user.UserRegisterDto;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import com.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/14
 **/
@RestController
@RequestMapping("/api/user/userInfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterDto userRegisterDto) {
        userInfoService.register(userRegisterDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
}
