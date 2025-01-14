package com.model.dto.system;

import com.model.entity.base.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/14
 **/
@Data
public class SysMenu extends BaseEntity {
    private Long parentId;
    private String title;
    private String component;
    private Integer sortValue;
    private Integer status;

    // 下级列表
    private List<SysMenu> children;
}
