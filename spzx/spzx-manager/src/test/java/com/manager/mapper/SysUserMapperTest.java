package com.manager.mapper;

import com.model.dto.system.LoginDto;
import com.model.entity.system.SysUser;
import org.junit.jupiter.api.Test;


/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/2
 **/
class SysUserMapperTest {
    SysUserMapper sysUserMapper ;
    @Test
    void selectByPrimaryKey() {
        LoginDto loginDto = new LoginDto();
        loginDto.setUserName("admin");
        SysUser sysUser = sysUserMapper.selectByUserName(loginDto.getUserName());
        System.out.println(sysUser);
    }


}