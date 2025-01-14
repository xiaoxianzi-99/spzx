package com.manager.mapper;

import com.model.dto.system.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/14
 **/
@Mapper
public interface SysMenuMapper {
    /**
     * 查询所有菜单
     * @return
     */
    List<SysMenu> findAllMenus();

    void saveSysMenu(SysMenu sysMenu);

    void updateSysMenu(SysMenu sysMenu);

    void deleteSysMenu(Long id);

    int findChildCount(Long id);
}
