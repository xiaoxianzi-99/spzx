package com.manager.controller;

import com.github.pagehelper.PageInfo;
import com.manager.service.SysUserService;
import com.model.dto.system.SysUserDto;
import com.model.entity.system.SysUser;
import com.model.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/10
 **/
@RestController
@RequestMapping(value = "/admin/system/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteSysUser/{id}")
    public Result deleteSysUser(@PathVariable("id") Long id) {
        sysUserService.deleteSysUser(id);
        return Result.build(null,200,"删除成功");
    }


    @PutMapping(value = "/updateSysUser")
    public Result updateSysUser(@RequestBody SysUser sysUser) {
        sysUserService.updateSysUser(sysUser);
        return Result.build(null,200,"修改成功");
    }
    /**
     * 保存用户
     * @param sysUser
     * @return
     */
    @PostMapping(value = "/saveSysUser")
    public Result saveSysUser(@RequestBody SysUser sysUser) {
        sysUserService.saveSysUser(sysUser);
        return Result.build(null,200,"保存成功");
    }

    /**
     * 分页查询用户
     * @param pageNum
     * @param pageSize
     * @param sysUserDto
     * @return
     */
    @GetMapping(value = "/findByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<SysUser>> findByPage(SysUserDto sysUserDto,
                                                @PathVariable("pageNum") Integer pageNum,
                                                @PathVariable("pageSize") Integer pageSize) {
        PageInfo<SysUser> pageInfo = sysUserService.findByPage(sysUserDto, pageNum, pageSize);
        return Result.build(pageInfo,200,"查询成功");
    }
}
