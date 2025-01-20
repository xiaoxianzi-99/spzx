package com.manager.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/16
 **/
@Mapper
public interface SysRoleMenuMapper {
    List<Long> findMenuIdByRoleId(Long roleId);

    void deleteByRoleId(Long roleId);

    void doAssign(Long roleId, List<Map<String, Number>> menuIdList);
}
