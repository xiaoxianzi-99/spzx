package com.model.dto.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/8
 **/
@Data
@Schema(description = "系统角色")
public class SysRoleDto {
    @Schema(description = "角色名称")
    private String roleName;

}
