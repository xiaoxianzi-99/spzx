package com.manager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mapper.SysUserMapper;
import com.manager.service.SysUserService;
import com.model.dto.system.LoginDto;
import com.model.dto.system.SysUserDto;
import com.model.entity.system.SysUser;
import com.model.vo.common.ResultCodeEnum;
import com.model.vo.system.LoginVo;
import com.service.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
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
    @Override
    public  SysUser getUserInfo(String token) {
        String strUser = redisTemplate.opsForValue().get("user:login:" + token);
        return JSON.parseObject(strUser, SysUser.class);
    }

    @Override
    public LoginVo login(LoginDto loginDto) {


        // 验证码校验
        // 获取redis中key
        String codeKey = loginDto.getCodeKey();
        String inputCaptcha = loginDto.getCaptcha();
        String redisCaptcha = redisTemplate.opsForValue().get("user:login:validatecode:" + codeKey);
        if(StrUtil.isEmpty(inputCaptcha)||!StrUtil.equalsIgnoreCase(redisCaptcha , inputCaptcha)) {
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

    @Override
    public void logout(String token) {
        redisTemplate.delete("user:login:" + token);
    }

    @Override
    public PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize) {
        //设置分页条件
        PageHelper.startPage(pageNum, pageSize);
        //查询用户列表
        List<SysUser> sysUserList = sysUserMapper.findByPage(sysUserDto);
        //封装分页结果
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserList);
        return pageInfo;
    }

    @Override
    public void saveSysUser(SysUser sysUser) {
        //判断是否存在新增用户
        SysUser user = sysUserMapper.selectByUserName(sysUser.getUserName());
        if(user != null) {
            throw new BusinessException(ResultCodeEnum.USER_NAME_IS_EXISTS);
        }
        //密码加密
        String password = sysUser.getPassword();
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        sysUser.setPassword(md5Password);
        //状态赋值
        sysUser.setStatus(1);
        sysUserMapper.saveSysUser(sysUser);
    }

    @Override
    public void updateSysUser(SysUser sysUser) {
        //判断用户账号是否重复
        SysUser user = sysUserMapper.selectByUserName(sysUser.getUserName());
        if(user != null && !user.getId().equals(sysUser.getId())) {
            throw new BusinessException(ResultCodeEnum.USER_NAME_IS_EXISTS);
        }
        sysUserMapper.updateSysUser(sysUser);
    }

    @Override
    public void deleteSysUser(Long id) {
        sysUserMapper.deleteSysUser(id);
    }
}
