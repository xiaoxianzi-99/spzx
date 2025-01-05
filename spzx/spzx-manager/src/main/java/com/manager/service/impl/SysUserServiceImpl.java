package com.manager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.manager.mapper.SysUserMapper;
import com.manager.service.SysUserService;
import com.model.dto.system.LoginDto;
import com.model.entity.system.SysUser;
import com.model.vo.common.ResultCodeEnum;
import com.model.vo.system.LoginVo;
import com.service.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper ;

    @Autowired
    private RedisTemplate<String , String> redisTemplate ;

    /**
     * 获取用户数据
     * @return
     */
    public  SysUser getUserInfo(String token) {
        return null;
    }

    @Override
    public LoginVo login(LoginDto loginDto) {


        // 验证码校验
        // 获取redis中key
        String codeKey = loginDto.getCodekey();
        String inputCaptcha = loginDto.getCaptcha();
        String redisCaptcha = redisTemplate.opsForValue().get("user:login:validatecode:" + codeKey);
        if(StrUtil.isEmpty(redisCaptcha)||!StrUtil.equalsIgnoreCase(redisCaptcha , inputCaptcha)) {
            throw new BusinessException(ResultCodeEnum.VALIDATECODE_ERROR);
        }
        redisTemplate.delete("user:login:validatecode:" + codeKey);
        // 根据用户名查询用户
        SysUser sysUser = sysUserMapper.selectByUserName(loginDto.getUserName());
        if(sysUser == null) {
            throw new BusinessException(ResultCodeEnum.LOGIN_ERROR);
        }

        // 验证密码是否正确
        String inputPassword = loginDto.getPassword();
        String md5InputPassword = DigestUtils.md5DigestAsHex(inputPassword.getBytes());
        if(!md5InputPassword.equals(sysUser.getPassword())) {
            throw new BusinessException(ResultCodeEnum.LOGIN_ERROR);
        }


        // 生成令牌，保存数据到Redis中
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set("user:login:" + token , JSON.toJSONString(sysUser) , 30 , TimeUnit.MINUTES);

        // 构建响应结果对象
        LoginVo loginVo = new LoginVo() ;
        loginVo.setToken(token);
        loginVo.setRefresh_token("");

        // 返回
        return loginVo;
    }
}
