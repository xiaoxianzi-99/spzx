package com.manager.helper;

import com.model.dto.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/14
 **/
public class MenuHelper {
    /**
     * 构建菜单树
     * @param menuList 菜单列表
     * @return 菜单树
     */
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        List<SysMenu> sysMenuListTree = new ArrayList<SysMenu>();
        //便利
        for (SysMenu sysMenu :sysMenuList){
            if(sysMenu.getParentId().intValue()==0){
                sysMenuListTree.add(findChildren(sysMenu,sysMenuList));
            }
        }
        return sysMenuListTree;
    }
    /**
     * 递归查找子菜单
     * @param sysMenu 父菜单
     * @param sysMenuList 菜单列表
     * @return
     */
    public static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> sysMenuList){
        for (SysMenu sysMenu1 : sysMenuList){
            if(sysMenu1.getParentId().intValue()==sysMenu.getId().intValue()){
                if(sysMenu.getChildren()==null){
                    sysMenu.setChildren(new ArrayList<SysMenu>());
                }
                sysMenu.getChildren().add(findChildren(sysMenu1,sysMenuList));
            }
        }
        return sysMenu;
    }
}
