package com.manager.controller;

import com.manager.service.SysRoleMenuService;
import com.model.dto.system.AssginMenuDto;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/16
 **/
@RestController
@RequestMapping(value = "/admin/system/sysRoleMenu")
public class sysRoleMenuController {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginMenuDto  assginMenuDto){
        sysRoleMenuService.doAssign(assginMenuDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    @GetMapping("/findSysRoleMenuByRoleId/{roleId}")
    public Result<Map<String, Object>> findSysRoleMenuByRoleId(@PathVariable("roleId") Long roleId) {
        Map<String, Object> resultMap = sysRoleMenuService.findSysRoleMenuByRoleId(roleId);
        return Result.build(resultMap, ResultCodeEnum.SUCCESS);
    }
}
