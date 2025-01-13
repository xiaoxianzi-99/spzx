package com.manager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/6
 **/
@Data
@ConfigurationProperties(prefix = "spzx.auth")
public class UserAuthProperties {
    private List<String> noAuthUrls ;
}
