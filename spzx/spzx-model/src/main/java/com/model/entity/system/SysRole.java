package com.model.entity.system;

import com.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/8
 **/
@Data
public class SysRole extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色编码")
    private String roleCode;

    @Schema(description = "描述")
    private String description;
}
