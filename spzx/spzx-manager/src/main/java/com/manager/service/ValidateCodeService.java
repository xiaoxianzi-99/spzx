package com.manager.service;

import com.model.vo.system.ValidateCodeVo;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/2
 **/
public interface ValidateCodeService {
    /**
     * 获取验证码
     * @return
     */
    public ValidateCodeVo generateValidateCode();
}
