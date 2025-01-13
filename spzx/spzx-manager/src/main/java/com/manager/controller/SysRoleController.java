package com.manager.controller;

import com.github.pagehelper.PageInfo;
import com.manager.service.SysRoleService;
import com.model.dto.system.SysRoleDto;
import com.model.entity.system.SysRole;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/8
 **/
@RestController
@Tag(name="系统角色")
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @DeleteMapping("/deleteSysRole/{id}")
    public Result deleteSysRole(@PathVariable("id") Long id){
        sysRoleService.deleteSysRole(id);
        return Result.build(null,200,"删除成功");
    }

    @PutMapping("/updateSysRole")
    public Result updateSysRole(@RequestBody SysRole sysRole){
        sysRoleService.updateSysRole(sysRole);
        return Result.build(null,200,"更新成功");
    }
    /**
     * 保存角色
     * @param sysRole
     * @return
     */
    @PostMapping("saveSysRole")
    public Result saveSysRole(@RequestBody SysRole sysRole,@RequestHeader(name="token") String token) {
        sysRoleService.saveSysRole(sysRole);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    /**
     * 条件分页查询角色列表
     * @param sysRoleDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("findByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<SysRole>> findByPage(SysRoleDto sysRoleDto,
                                                @PathVariable("pageNum") Integer pageNum,
                                                @PathVariable("pageSize") Integer pageSize) {
        PageInfo<SysRole> rolePageInfo = sysRoleService.findByPage(sysRoleDto, pageNum, pageSize);
        return Result.build(rolePageInfo, ResultCodeEnum.SUCCESS);
    }
}
