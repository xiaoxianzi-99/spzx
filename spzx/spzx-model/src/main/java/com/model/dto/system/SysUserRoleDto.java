package com.model.dto.system;

import lombok.Data;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/13
 **/
@Data
public class SysUserRoleDto {
    private Long userId;
    private List<Long> roleIdList;
}
