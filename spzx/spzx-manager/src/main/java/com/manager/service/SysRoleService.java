package com.manager.service;

import com.github.pagehelper.PageInfo;
import com.model.dto.system.SysRoleDto;
import com.model.entity.system.SysRole;

import java.util.Map;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/8
 **/
public interface SysRoleService {
    PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer pageNum,Integer pageSize);

    void saveSysRole(SysRole sysRole);
    void updateSysRole(SysRole sysRole);
    void deleteSysRole(Long id);

    Map<String, Object> findAllRoles(Long userId);
}
