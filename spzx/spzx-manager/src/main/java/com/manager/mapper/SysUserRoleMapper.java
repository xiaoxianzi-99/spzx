package com.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/13
 **/
@Mapper
public interface SysUserRoleMapper {

    public void deleteUserRole(Long userId);

    void addUserRole(@Param(value = "userId") Long userId,@Param(value = "roleId") Long roleId);

    List<Long> getRoleByUserId(Long userId);
}
