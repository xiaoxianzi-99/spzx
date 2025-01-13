package com.manager.controller;

import com.manager.service.SysUserRoleService;
import com.model.dto.system.SysUserRoleDto;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/13
 **/
@RestController
@RequestMapping(value = "/admin/system/sysUserRole")
public class SysUserRoleController {
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @GetMapping(value = "/getRoleByUserId/{userId}")
    public Result<List<Long>> getRoleByUserId(@PathVariable("userId") Long userId) {
        List<Long> roleIdList = sysUserRoleService.getRoleByUserId(userId);
        return Result.build(roleIdList, ResultCodeEnum.SUCCESS);
    }

    @PostMapping(value = "/addUserRoles")
    public Result addUserRole(@RequestBody SysUserRoleDto sysUserRoleDto) {
        sysUserRoleService.addUserRole(sysUserRoleDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
}
