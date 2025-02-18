package com.feign.cart;

import com.model.entity.h5.CartInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@FeignClient(value = "service-cart")
public interface CartFeignClient {
    @GetMapping(value = "/api/order/cart/auth/getAllCkecked")
    public abstract List<CartInfo> getAllCkecked();
    @GetMapping(value = "/api/order/cart/auth/deleteChecked")
    public abstract void deleteChecked() ;
}
