package com.gj.common.oss;

import com.gj.common.config.OssConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OssFactory {
    @Autowired
    OssConfig ossConfig;

    public OssService build() {
        if (ossConfig.getType() == 1) {
            return new AliyunOssService(ossConfig);
        }
        return null;
    }
}
