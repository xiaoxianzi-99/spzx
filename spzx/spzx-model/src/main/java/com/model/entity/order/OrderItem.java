package com.model.entity.order;

import com.model.entity.base.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@Data
public class OrderItem extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long orderId;
    private Long skuId;
    private String skuName;
    private String thumbImg;
    private BigDecimal skuPrice;
    private Integer skuNum;
}
