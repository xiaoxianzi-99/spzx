package com.model.entity.system;

import com.model.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/13
 **/
@Data
public class SysUserRole extends BaseEntity {
    private Long userId;
    private Long roleId;
}
