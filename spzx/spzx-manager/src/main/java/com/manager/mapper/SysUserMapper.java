package com.manager.mapper;

import com.model.dto.system.SysUserDto;
import com.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@Mapper
public interface SysUserMapper {
    /**
     * 用户登录
     * @param userName
     * @return
     */
    SysUser selectByUserName(String userName);

    List<SysUser> findByPage(SysUserDto sysUserDto);

    void saveSysUser(SysUser sysUser);
    void updateSysUser(SysUser sysUser);

    void deleteSysUser(Long id);
}
