package com.cart.controller;

import com.cart.service.CartService;
import com.model.entity.h5.CartInfo;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@RestController
@RequestMapping("api/order/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("auth/addToCart/{skuId}/{skuNum}")
    public Result addToCart( @PathVariable("skuId") Long skuId,
                            @PathVariable("skuNum") Integer skuNum) {
        cartService.addToCart(skuId, skuNum);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    @GetMapping("/auth/cartList")
    public Result<List<CartInfo>> cartList() {
        List<CartInfo> cartInfoList = cartService.getCartList();
        return Result.build(cartInfoList, ResultCodeEnum.SUCCESS);
    }
    @DeleteMapping("/auth/deleteCart/{skuId}")
    public Result deleteCart(@PathVariable("skuId") Long skuId) {
        cartService.deleteCart(skuId);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    @GetMapping("/auth/checkCart/{skuId}/{isChecked}")
    public Result checkCart(@PathVariable("skuId") Long skuId,
                            @PathVariable("isChecked") Integer isChecked) {
        cartService.checkCart(skuId, isChecked);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    //全选
    @GetMapping("/auth/allCheckCart/{isChecked}")
    public Result allCheckCart(@PathVariable("isChecked") Integer isChecked) {
        cartService.allCheckCart(isChecked);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    //清空
    @DeleteMapping("/auth/clearCart")
    public Result clearCart() {
        cartService.clearCart();
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
    @GetMapping("/auth/getAllCkecked")
    public List<CartInfo> getAllCkecked() {
        List<CartInfo> cartInfoList = cartService.getAllCkecked() ;
        return cartInfoList;
    }
    @GetMapping(value = "/auth/deleteChecked")
    public void deleteChecked() {
        cartService.deleteChecked() ;
    }
}
