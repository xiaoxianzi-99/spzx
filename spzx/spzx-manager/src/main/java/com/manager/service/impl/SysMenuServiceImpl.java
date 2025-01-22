package com.manager.service.impl;

import com.manager.util.MenuHelper;
import com.manager.mapper.SysMenuMapper;
import com.manager.service.SysMenuService;
import com.model.dto.system.SysMenu;
import com.model.vo.common.ResultCodeEnum;
import com.model.vo.system.SysMenuVo;
import com.service.exception.BusinessException;
import com.utils.AuthContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/14
 **/
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> findNodes() {
        //查询所有的菜单
        List<SysMenu> sysMenuList = sysMenuMapper.findAllMenus();
        if(CollectionUtils.isEmpty(sysMenuList)){
            return null;
        }
        //构建树形结构
        List<SysMenu> sysMenuListTree= MenuHelper.buildTree(sysMenuList);
        return sysMenuListTree;
    }

    @Override
    public void saveSysMenu(SysMenu sysMenu) {
        sysMenuMapper.saveSysMenu(sysMenu);
    }

    @Override
    public void updateSysMenu(SysMenu sysMenu) {
        sysMenuMapper.updateSysMenu(sysMenu);
    }

    @Override
    public void deleteSysMenu(Long id) {
        //查询子菜单数量
        int count = sysMenuMapper.findChildCount(id);
        if(count>0){
            throw new BusinessException(ResultCodeEnum.NODE_ERROR);
        }
        sysMenuMapper.deleteSysMenu(id);
    }

    @Override
    public List<SysMenuVo> getMenus() {
        Long userId = AuthContextUtil.get().getId();
        List<SysMenu> sysMenuList = sysMenuMapper.selectMenuByUserId(userId);
        if(CollectionUtils.isEmpty(sysMenuList))return null;
        List<SysMenu> sysMenuListTree = MenuHelper.buildTree(sysMenuList);
        List<SysMenuVo> sysMenuVoList = new ArrayList<>();
        return MenuHelper.buildMenus(sysMenuListTree);
    }
}
