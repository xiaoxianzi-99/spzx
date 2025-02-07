package com.manager.service.impl;

import cn.hutool.core.date.DateUtil;
import com.manager.mapper.OrderStatisticsMapper;
import com.manager.service.OrderStatisticsService;
import com.model.dto.order.OrderStatisticsDto;
import com.model.entity.order.OrderStatistics;
import com.model.vo.order.OrderStatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/24
 **/
@Service

public class OrderStatisticsServiceImpl implements OrderStatisticsService {
    @Autowired
    private OrderStatisticsMapper orderStatisticsMapper;
    @Override
    public OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto) {
        List<OrderStatistics> orderStatisticsList = orderStatisticsMapper.selectOrderStatisticsList(orderStatisticsDto);
        List<String> dateList = orderStatisticsList.stream().map(orderStatistics -> {
            String dateTime = DateUtil.format(orderStatistics.getOrderDate(), "yyyy-MM-dd");
            return dateTime;
        }).collect(Collectors.toList());
        List<BigDecimal> amountList = orderStatisticsList.stream().map(orderStatistics -> {
            return orderStatistics.getTotalAmount();
        }).collect(Collectors.toList());
        OrderStatisticsVo orderStatisticsVo = new OrderStatisticsVo();
        orderStatisticsVo.setDateList(dateList);
        orderStatisticsVo.setAmountList(amountList);
        return orderStatisticsVo;
    }
}
