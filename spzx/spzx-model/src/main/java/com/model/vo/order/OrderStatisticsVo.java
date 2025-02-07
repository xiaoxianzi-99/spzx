package com.model.vo.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/24
 **/
@Data
public class OrderStatisticsVo {
    private List<String> dateList;
    private List<BigDecimal> amountList;
}
