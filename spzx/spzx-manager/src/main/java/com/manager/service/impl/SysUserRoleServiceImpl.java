package com.manager.service.impl;

import com.manager.mapper.SysUserRoleMapper;
import com.manager.service.SysUserRoleService;
import com.model.dto.system.SysUserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/13
 **/
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public void addUserRole(SysUserRoleDto sysUserRoleDto) {
        //删除改用户之前的角色
        sysUserRoleMapper.deleteUserRole(sysUserRoleDto.getUserId());
        //添加新的角色
        List<Long> roleIdList = sysUserRoleDto.getRoleIdList();
        roleIdList.forEach(roleId->{
            sysUserRoleMapper.addUserRole(sysUserRoleDto.getUserId(),roleId);
        });
    }

    @Override
    public List<Long> getRoleByUserId(Long userId) {
        return sysUserRoleMapper.getRoleByUserId(userId);
    }
}
