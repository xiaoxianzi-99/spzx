package com.order.service;

import com.github.pagehelper.PageInfo;
import com.model.dto.order.OrderInfoDto;
import com.model.entity.order.OrderInfo;
import com.model.vo.h5.TradeVo;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
public interface OrderInfoService {
    TradeVo getTrade();

    Long submitOrder(OrderInfoDto orderInfoDto);

    OrderInfo getOrderInfo(Long orderId);

    TradeVo buy(Long skuId);

    PageInfo<OrderInfo> findUserPage(Integer page, Integer limit, Integer orderStatus);

    OrderInfo getOrderInfoByOrderNo(String orderNo);

    void updateOrderStatus(String orderNo, Integer orderStatus);
}
