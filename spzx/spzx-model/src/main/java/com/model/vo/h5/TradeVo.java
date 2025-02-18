package com.model.vo.h5;

import com.model.entity.order.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@Data
public class TradeVo {
    private BigDecimal totalAmount;
    private List<OrderItem> orderItemList;

}
