package com.pay;

import com.pay.properties.AlipayProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.feign.order","com.feign.product"})
@EnableConfigurationProperties(value = { AlipayProperties.class })
public class PayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}
