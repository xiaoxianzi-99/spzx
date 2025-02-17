package com.model.entity.h5;

import com.model.entity.base.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@Data
public class CartInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private Long skuId;
    private BigDecimal cartPrice;
    private Integer skuNum;
    private String imgUrl;
    private String skuName;
    private Integer isChecked;
}
