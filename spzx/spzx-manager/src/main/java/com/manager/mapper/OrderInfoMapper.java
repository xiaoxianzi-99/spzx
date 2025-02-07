package com.manager.mapper;

import com.model.entity.order.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/24
 **/
@Mapper
public interface OrderInfoMapper {
    OrderStatistics orderTotalAmountStastistics(String createTime);
}
