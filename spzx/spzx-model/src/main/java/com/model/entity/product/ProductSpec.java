package com.model.entity.product;

import com.model.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/21
 **/
@Data
public class ProductSpec extends BaseEntity {
    private String specName;
    private String specValue;
}
