package com.gj.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "oss")
@Data
public class OssConfig {
    Integer type;//1:阿里云
    String domain;
    String prefix;
    String endPoint;
    String accessKeyId;
    String accessKeySecret;
    String bucketName;
}
