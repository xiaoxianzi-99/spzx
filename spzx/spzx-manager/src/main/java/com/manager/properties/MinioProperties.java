package com.manager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/13
 **/
@Data
@ConfigurationProperties(prefix = "spzx.minio")
public class MinioProperties {
    private String endpointUrl;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
