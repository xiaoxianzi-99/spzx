package com.pay.service;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
public interface AlipayService {
    String submitAlipay(String orderNo);

    boolean refund(String orderNo);
}
