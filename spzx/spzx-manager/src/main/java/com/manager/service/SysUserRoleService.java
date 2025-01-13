package com.manager.service;

import com.model.dto.system.SysUserRoleDto;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/13
 **/

public interface SysUserRoleService {

    void addUserRole(SysUserRoleDto sysUserRoleDto);

    List<Long> getRoleByUserId(Long userId);
}
