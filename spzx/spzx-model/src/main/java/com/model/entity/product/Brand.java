package com.model.entity.product;

import com.model.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/18
 **/
@Data
public class Brand extends BaseEntity {
    private String name;
    private String logo;
}
