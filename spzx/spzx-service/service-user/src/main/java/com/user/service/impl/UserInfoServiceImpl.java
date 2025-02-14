package com.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.model.dto.user.UserRegisterDto;
import com.model.entity.user.UserInfo;
import com.model.vo.common.ResultCodeEnum;
import com.service.exception.BusinessException;
import com.user.mapper.UserInfoMapper;
import com.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
        userInfo.setAvatar("http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132");
        userInfoMapper.save(userInfo);
        redisTemplate.delete("phone:code:" + username);
    }
}
