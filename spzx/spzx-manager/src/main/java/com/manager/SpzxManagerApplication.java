package com.manager;

import com.manager.properties.UserAuthProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@ComponentScan(basePackages = "com")
@SpringBootApplication
@EnableConfigurationProperties(value = {UserAuthProperties.class})
public class SpzxManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpzxManagerApplication.class, args);
    }
}
