package com.manager.service;

import com.model.dto.order.OrderStatisticsDto;
import com.model.vo.order.OrderStatisticsVo;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/24
 **/
public interface OrderStatisticsService {
    OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto);
}
