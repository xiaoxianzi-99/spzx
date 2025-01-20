package com.manager.service.impl;

import com.manager.mapper.SysRoleMenuMapper;
import com.manager.service.SysMenuService;
import com.manager.service.SysRoleMenuService;
import com.model.dto.system.AssginMenuDto;
import com.model.dto.system.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/16
 **/
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private SysMenuService sysMenuService;
    @Override
    public Map<String, Object> findSysRoleMenuByRoleId(Long roleId) {
        Map<String, Object> resultMap = new HashMap<>();
        List<SysMenu> menuListTree = sysMenuService.findNodes();
        resultMap.put("menuList", menuListTree);
        List<Long> menuIdList = sysRoleMenuMapper.findMenuIdByRoleId(roleId);
        resultMap.put("menuIdList", menuIdList);
        return resultMap;
    }

    @Override
    public void doAssign(AssginMenuDto assginMenuDto) {
        //删除之前所有的菜单
        sysRoleMenuMapper.deleteByRoleId(assginMenuDto.getRoleId());
        List<Map<String, Number>> menuIdList = assginMenuDto.getMenuIdList();
        if(!CollectionUtils.isEmpty(menuIdList)){
            sysRoleMenuMapper.doAssign(assginMenuDto.getRoleId(), menuIdList);

        }
    }
}
