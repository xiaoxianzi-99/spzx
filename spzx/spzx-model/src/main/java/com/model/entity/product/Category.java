package com.model.entity.product;

import com.model.entity.base.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/17
 **/
@Data
public class Category extends BaseEntity {
    private String name;
    private String imageUrl;
    private Long parentId;
    private Integer status;
    private Integer orderNum;

    private Boolean hasChildren;

    private List<Category> children;
}
