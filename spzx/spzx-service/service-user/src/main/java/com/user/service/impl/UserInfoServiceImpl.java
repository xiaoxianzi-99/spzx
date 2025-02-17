package com.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.model.dto.user.UserLoginDto;
import com.model.dto.user.UserRegisterDto;
import com.model.entity.user.UserInfo;
import com.model.vo.common.ResultCodeEnum;
import com.model.vo.user.UserInfoVo;
import com.service.exception.BusinessException;
import com.service.utils.AuthContextUtil;
import com.user.mapper.UserInfoMapper;
import com.user.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/14
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    /**
     * @param userRegisterDto
     */
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Override
    public void register(UserRegisterDto userRegisterDto) {
        String username = userRegisterDto.getUsername();
        String password = userRegisterDto.getPassword();
        String nickName = userRegisterDto.getNickName();
        String code = userRegisterDto.getCode();
        if (StrUtil.hasBlank(username, password, nickName, code)) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }
        String codeValueRedis = redisTemplate.opsForValue().get("phone:code:" + username);
        if (!code.equals(codeValueRedis)) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }
        UserInfo userInfo = userInfoMapper.getByUsername(username);
        if(userInfo != null) {
            throw new BusinessException(ResultCodeEnum.USER_NAME_IS_EXISTS);
        }
        //保存用户信息
        userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setNickName(nickName);
        userInfo.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userInfo.setPhone(username);
        userInfo.setStatus(1);
        userInfo.setSex(0);
        userInfo.setAvatar("https://www.mianshiya.com/assets/notLoginUser.png");
        userInfoMapper.save(userInfo);
        redisTemplate.delete("phone:code:" + username);
    }

    /**
     * 登录
     * @param userLoginDto
     * @param ip
     * @return
     */
    @Override
    public Object login(UserLoginDto userLoginDto, String ip) {
        String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();
        if(StrUtil.hasBlank(username, password)) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }
        UserInfo userInfo = userInfoMapper.getByUsername(username);
        if(null == userInfo) {
            throw new BusinessException(ResultCodeEnum.LOGIN_ERROR);
        }
        //校验密码
        String md5InputPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if(!md5InputPassword.equals(userInfo.getPassword())) {
            throw new BusinessException(ResultCodeEnum.LOGIN_ERROR);
        }
        //校验是否被禁用
        if(userInfo.getStatus() == 0) {
            throw new BusinessException(ResultCodeEnum.ACCOUNT_STOP);
        }

        //更新登录信息
        userInfo.setLastLoginIp(ip);
        userInfo.setLastLoginTime(new Date());
        userInfoMapper.updateById(userInfo);
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForValue().set("user:login:" + token, JSON.toJSONString(userInfo), 30, TimeUnit.DAYS);
        return token;
    }

    /**
     * @param token
     * @return
     */
    @Override
    public UserInfoVo getCurrentUserInfo(String token) {
        UserInfo userInfo = AuthContextUtil.getUserInfo();
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(userInfo, userInfoVo);
        return userInfoVo ;
    }
}
