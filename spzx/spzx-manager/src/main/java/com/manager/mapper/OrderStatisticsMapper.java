package com.manager.mapper;

import com.model.dto.order.OrderStatisticsDto;
import com.model.entity.order.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/24
 **/
@Mapper
public interface OrderStatisticsMapper {
    void insert(OrderStatistics orderStatistics);

    List<OrderStatistics> selectOrderStatisticsList(OrderStatisticsDto orderStatisticsDto);
}
