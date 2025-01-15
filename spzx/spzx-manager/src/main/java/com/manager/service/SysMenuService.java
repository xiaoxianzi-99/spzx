package com.manager.service;

import com.model.dto.system.SysMenu;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/14
 **/
public interface SysMenuService {
    List<SysMenu> findNodes();

    void saveSysMenu(SysMenu sysMenu);

    void updateSysMenu(SysMenu sysMenu);

    void deleteSysMenu(Long id);
}
