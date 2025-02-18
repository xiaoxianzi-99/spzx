package com.model.entity.pay;

import com.model.entity.base.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@Data
public class PaymentInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String orderNo;
    private Integer payType;
    private String outTradeNo;
    private BigDecimal amount;
    private String content;
    private Integer paymentStatus;
    private Date callbackTime;
    private String callbackContent;
}
