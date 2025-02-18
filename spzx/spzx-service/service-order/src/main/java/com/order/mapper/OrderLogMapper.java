package com.order.mapper;

import com.model.entity.order.OrderLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@Mapper
public interface OrderLogMapper {
    void save(OrderLog orderLog);
}
