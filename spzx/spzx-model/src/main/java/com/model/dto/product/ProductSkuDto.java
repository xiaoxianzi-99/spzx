package com.model.dto.product;

import lombok.Data;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/10
 **/
@Data
public class ProductSkuDto {
    private String keyword;
    private Long brandId;
    private Long category1Id;
    private Long category2Id;
    private Long category3Id;
    //排序规则
    private Integer order = 1;
}
