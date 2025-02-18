package com.order;

import com.service.anno.EnableUserTokenFeignInterceptor;
import com.service.anno.EnableUserWebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.feign.cart","com.feign.user","com.feign.product"})
@EnableUserTokenFeignInterceptor
@EnableUserWebMvcConfiguration
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
