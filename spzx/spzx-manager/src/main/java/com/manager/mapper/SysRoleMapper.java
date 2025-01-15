package com.manager.mapper;

import com.model.dto.system.SysRoleDto;
import com.model.entity.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/8
 **/
@Mapper
public interface SysRoleMapper {
    public List<SysRole> findByPage(SysRoleDto sysRoleDto);
    void saveSysRole(SysRole sysRole);
    void updateSysRole(SysRole sysRole);
    void deleteSysRole(Long id);

    List<SysRole> findAllRoles();
}
