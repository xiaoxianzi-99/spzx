package com.model.entity.order;

import com.model.entity.base.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/24
 **/
@Data
public class OrderStatistics extends BaseEntity {
    private String provinceCode;
    private Date orderDate;
    private BigDecimal totalAmount;
    private Integer totalNum;
}
