package com.order.controller;

import com.github.pagehelper.PageInfo;
import com.model.dto.order.OrderInfoDto;
import com.model.entity.order.OrderInfo;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import com.model.vo.h5.TradeVo;
import com.order.service.OrderInfoService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@RestController
@RequestMapping(value="/api/order/orderInfo")
public class OrderInfoController {
    @Autowired
    OrderInfoService orderInfoService;
    @GetMapping("auth/trade")
    public Result<TradeVo> trade() {
        TradeVo tradeVo = orderInfoService.getTrade();
        return Result.build(tradeVo, ResultCodeEnum.SUCCESS);
    }

    /**
     * 提交订单
     * @param orderInfoDto
     * @return
     */
    @PostMapping("auth/submitOrder")
    public Result<Long> submitOrder(@RequestBody OrderInfoDto orderInfoDto) {
        Long orderId = orderInfoService.submitOrder(orderInfoDto);
        return Result.build(orderId, ResultCodeEnum.SUCCESS);
    }

    /**
     * 根据订单id获取订单信息
     * @param orderId
     * @return
     */
    @GetMapping("auth/{orderId}")
    public Result<OrderInfo> getOrderInfo(@Parameter(name = "orderId", description = "订单id", required = true) @PathVariable Long orderId) {
        OrderInfo orderInfo = orderInfoService.getOrderInfo(orderId);
        return Result.build(orderInfo, ResultCodeEnum.SUCCESS);
    }

    /**
     * 立即购买
     * @param skuId
     * @return
     */
    @GetMapping("auth/buy/{skuId}")
    public Result<TradeVo> buy(@Parameter(name = "skuId", description = "商品skuId", required = true) @PathVariable Long skuId) {
        TradeVo tradeVo = orderInfoService.buy(skuId);
        return Result.build(tradeVo, ResultCodeEnum.SUCCESS);
    }
    /**
     * 分页查询订单列表
     * @param page
     * @param limit
     * @param orderStatus
     * @return
     */
    @GetMapping("auth/{page}/{limit}")
    public Result<PageInfo<OrderInfo>> list(
            @PathVariable Integer page,
            @PathVariable Integer limit,
            @RequestParam(required = false, defaultValue = "") Integer orderStatus) {
        PageInfo<OrderInfo> pageInfo = orderInfoService.findUserPage(page, limit, orderStatus);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }

    /**
     * 根据订单号获取订单信息
     * @param orderNo
     * @return
     */
    @GetMapping("auth/getOrderInfoByOrderNo/{orderNo}")
    public OrderInfo getOrderInfoByOrderNo(@PathVariable String orderNo) {
        return orderInfoService.getOrderInfoByOrderNo(orderNo);
    }

    /**
     * 更新订单状态
     * @param orderNo
     * @param orderStatus
     * @return
     */
    @GetMapping("auth/updateOrderStatusPayed/{orderNo}/{orderStatus}")
    public void updateOrderStatus(@PathVariable(value = "orderNo") String orderNo , @PathVariable(value = "orderStatus") Integer orderStatus) {
        orderInfoService.updateOrderStatus(orderNo , orderStatus);
    }
}
