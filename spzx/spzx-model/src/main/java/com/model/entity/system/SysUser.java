package com.model.entity.system;

import com.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@Data
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String userName;  // 该字段的属性名称和数据表字段不一致
    private String password;
    private String name;
    private String phone;
    private String avatar;
    private String description;
    @Schema(description="状态,1:正常,0:禁用")
    private Integer status;
}
