package com.user.service;

import com.model.dto.user.UserLoginDto;
import com.model.dto.user.UserRegisterDto;
import com.model.vo.user.UserInfoVo;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/14
 **/
public interface UserInfoService {
    void register(UserRegisterDto userRegisterDto);

    Object login(UserLoginDto userLoginDto, String ip);

    UserInfoVo getCurrentUserInfo(String token);
}
