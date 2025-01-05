package com.manager.mapper;

import com.model.dto.system.LoginDto;
import com.model.entity.system.SysUser;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/2
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
class SysUserMapperTest {
    @Resource
    SysUserMapper sysUserMapper ;
    @Test
    void selectByPrimaryKey() {
        LoginDto loginDto = new LoginDto();
        loginDto.setUserName("admin");
        SysUser sysUser = sysUserMapper.selectByUserName(loginDto.getUserName());
        System.out.println(sysUser);
    }


}