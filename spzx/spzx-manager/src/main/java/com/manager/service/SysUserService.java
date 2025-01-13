package com.manager.service;

import com.github.pagehelper.PageInfo;
import com.model.dto.system.LoginDto;
import com.model.dto.system.SysUserDto;
import com.model.entity.system.SysUser;
import com.model.vo.system.LoginVo;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/

public interface SysUserService {
    /**
     * 根据用户名查询用户数据
     * @return
     */
    public abstract LoginVo login(LoginDto loginDto) ;

    /**
     * 获取用户信息
     * @return
     */
    public abstract SysUser getUserInfo(String token) ;

    public abstract void  logout(String token) ;

    PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize);

    void saveSysUser(SysUser sysUser);

    void updateSysUser(SysUser sysUser);

    void deleteSysUser(Long id);
}

