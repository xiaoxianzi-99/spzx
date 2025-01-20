package com.manager.service;

import com.model.dto.system.AssginMenuDto;

import java.util.Map;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/16
 **/
public interface SysRoleMenuService {
    Map<String, Object> findSysRoleMenuByRoleId(Long roleId);

    void doAssign(AssginMenuDto assginMenuDto);
}
