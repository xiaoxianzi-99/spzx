package com.model.dto.product;

import com.model.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/22
 **/
@Data
public class ProductDto extends BaseEntity {
    private Long brandId;
    private Long category1Id;
    private Long category2Id;
    private Long category3Id;
}
