package com.manager.mapper;

import com.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@Mapper
public interface SysUserMapper {
    /**
     * 用户登录
     * @param userName
     * @return
     */
    SysUser selectByUserName(String userName);
}
