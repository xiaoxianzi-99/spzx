package com.manager.service;

import com.model.dto.system.LoginDto;
import com.model.vo.system.LoginVo;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/

public interface SysUserService {
    /**
     * 根据用户名查询用户数据
     * @return
     */
    public abstract LoginVo login(LoginDto loginDto) ;

}

