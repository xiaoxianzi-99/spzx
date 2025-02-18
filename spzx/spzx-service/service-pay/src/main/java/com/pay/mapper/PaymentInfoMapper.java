package com.pay.mapper;

import com.model.entity.pay.PaymentInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@Mapper
public interface PaymentInfoMapper {
    public PaymentInfo getByOrderNo(String orderNo) ;

    public void save(PaymentInfo paymentInfo) ;

    void updateById(PaymentInfo paymentInfo);
}
