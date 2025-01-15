package com.manager.controller;

import com.manager.service.SysMenuService;
import com.model.dto.system.SysMenu;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/14
 **/
@RestController
@RequestMapping(value = "/admin/system/sysMenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
    @GetMapping("/findNodes")
    public Result<List<SysMenu>> findNodes() {
        List<SysMenu> sysMenuList = sysMenuService.findNodes();
        return Result.build(sysMenuList, ResultCodeEnum.SUCCESS);
    }
    @PostMapping("/save")
    public Result saveSysMenu(@RequestBody SysMenu sysMenu) {
        sysMenuService.saveSysMenu(sysMenu);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    @PutMapping("/updateById")
    public Result updateSysMenu(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateSysMenu(sysMenu);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
    @DeleteMapping("/deleteById/{id}")
    public Result deleteSysMenu(@PathVariable("id") Long id) {
        sysMenuService.deleteSysMenu(id);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
}
