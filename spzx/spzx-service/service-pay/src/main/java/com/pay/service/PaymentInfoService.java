package com.pay.service;

import com.model.entity.pay.PaymentInfo;

import java.util.Map;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
public interface PaymentInfoService {
    PaymentInfo savePaymentInfo(String orderNo);

    /**
     * 更新支付信息
     * @param map
     * @param payType
     */
    void updatePaymentStatus(Map<String, String> map, Integer payType);
}
