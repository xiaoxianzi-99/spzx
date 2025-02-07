package com.manager;

import com.manager.properties.MinioProperties;
import com.manager.properties.UserAuthProperties;
import common.log.annotation.EnableLogAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/1
 **/
@EnableAsync
@ComponentScan(basePackages = "com")
@SpringBootApplication
@EnableScheduling
@EnableLogAspect
@EnableConfigurationProperties(value = {UserAuthProperties.class, MinioProperties.class})
public class SpzxManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpzxManagerApplication.class, args);
    }
}
