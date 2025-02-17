package com.user.controller;

import com.model.dto.user.UserLoginDto;
import com.model.dto.user.UserRegisterDto;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import com.model.vo.user.UserInfoVo;
import com.user.service.UserInfoService;
import com.utils.IpUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/14
 **/
@RestController
@RequestMapping("/api/user/userInfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDto userLoginDto, HttpServletRequest request) {
        String ip = IpUtil.getIpAddress(request);
        return Result.build(userInfoService.login(userLoginDto,ip), ResultCodeEnum.SUCCESS);
    }
    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterDto userRegisterDto) {
        userInfoService.register(userRegisterDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    @GetMapping("/auth/getCurrentUserInfo")
    public Result getCurrentUserInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        UserInfoVo userInfoVo = userInfoService.getCurrentUserInfo(token) ;
        return Result.build(userInfoVo, ResultCodeEnum.SUCCESS);
    }
}
