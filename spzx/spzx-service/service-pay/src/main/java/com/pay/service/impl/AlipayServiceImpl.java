package com.pay.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.model.entity.pay.PaymentInfo;
import com.model.vo.common.ResultCodeEnum;
import com.pay.properties.AlipayProperties;
import com.pay.service.AlipayService;
import com.pay.service.PaymentInfoService;
import com.service.exception.BusinessException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@Slf4j
@Service
public class AlipayServiceImpl implements AlipayService {

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private PaymentInfoService paymentInfoService;

    @Autowired
    private AlipayProperties alipayProperties ;

    @SneakyThrows  // lombok的注解，对外声明异常
    @Override
    public String submitAlipay(String orderNo) {

        //保存支付记录
        PaymentInfo paymentInfo = paymentInfoService.savePaymentInfo(orderNo);

        //创建API对应的request
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();

        // 同步回调
        alipayRequest.setReturnUrl(alipayProperties.getReturnPaymentUrl());

        // 异步回调
        alipayRequest.setNotifyUrl(alipayProperties.getNotifyPaymentUrl());

        // 准备请求参数 ，声明一个map 集合
        HashMap<String, Object> map = new HashMap<>();
        map.put("out_trade_no",paymentInfo.getOrderNo());
        map.put("product_code","QUICK_WAP_WAY");
        //map.put("total_amount",paymentInfo.getAmount());
        map.put("total_amount",paymentInfo.getAmount());
        map.put("subject",paymentInfo.getContent());
        alipayRequest.setBizContent(JSON.toJSONString(map));

        // 发送请求
        AlipayTradeWapPayResponse response = alipayClient.pageExecute(alipayRequest);
        if(response.isSuccess()){
            log.info("调用成功");
            return response.getBody();
        } else {
            log.info("调用失败");
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }
    }

    /**
     * 退款实现
     * @param orderNo
     * @return
     *
     * 退款成功判断说明：
     * 接口返回
     * fund_change=Y为退款成功，
     * fund_change=N
     * 注意，接口中code=10000，仅代表本次退款请求成功，不代表退款成功。
     */
    @Override
    @SneakyThrows
    public boolean refund(String orderNo) {
        PaymentInfo paymentInfo = paymentInfoService.savePaymentInfo(orderNo);
        //初始化退款请求对象
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        JSONObject bizContent = new JSONObject();
//        bizContent.put("trade_no", "2021081722001419121412730660");
        bizContent.put("refund_amount", paymentInfo.getAmount());
        bizContent.put("out_trade_no", orderNo);


        request.setBizContent(bizContent.toString());
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
            String fundChange = response.getFundChange();
            if("Y".equals(fundChange)){

                System.out.println("退款成功。。。。");
                return true;
            }else{
                return false;
            }

        } else {
            System.out.println("调用失败");
            return false;
        }

    }
}
