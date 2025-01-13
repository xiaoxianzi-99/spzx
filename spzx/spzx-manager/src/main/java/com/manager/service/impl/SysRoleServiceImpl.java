package com.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.mapper.SysRoleMapper;
import com.manager.service.SysRoleService;
import com.model.dto.system.SysRoleDto;
import com.model.entity.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/8
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 删除角色
     * @param id
     */
    public void deleteSysRole(Long id){
        sysRoleMapper.deleteSysRole(id);
    }
    /**
     * 保存角色
     * @param sysRole
     */

    public void updateSysRole(SysRole sysRole){
        sysRoleMapper.updateSysRole(sysRole);
    }

    @Override
    public void saveSysRole(SysRole sysRole){
        sysRoleMapper.saveSysRole(sysRole);
    }

    /**
     * 分页查询角色列表
     * @param sysRoleDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer pageNum, Integer pageSize) {
        //封装分页查询条件
        PageHelper.startPage(pageNum, pageSize);
        //查询角色列表
        List<SysRole> sysRoleList = sysRoleMapper.findByPage(sysRoleDto);
        //转换数据类型
        return new PageInfo<>(sysRoleList);
    }
}
