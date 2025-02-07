package com.manager.scheduled;

import cn.hutool.core.date.DateUtil;
import com.manager.mapper.OrderInfoMapper;
import com.manager.mapper.OrderStatisticsMapper;
import com.model.entity.order.OrderStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/24
 **/
@Component
public class OrderStastisticsTask {
    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    OrderStatisticsMapper orderStatisticsMapper;
    /**
     * 每天定时统计前一天订单总金额
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void orderTotalAmountStastistics(){
        String createTime = DateUtil.yesterday().toString(new SimpleDateFormat("yyyy-MM-dd"));
        OrderStatistics orderStatistics = orderInfoMapper.orderTotalAmountStastistics(createTime);
        if(orderStatistics == null){
            return;
        }
        orderStatisticsMapper.insert(orderStatistics);
    }
}
