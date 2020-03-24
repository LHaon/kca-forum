package com.mezjh.kcaforum.common.utils.message;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zjh
 * @date 2020/3/24
 */
@Component
@ConfigurationProperties(
    prefix = "msg.config"
)
@Data
public class MessageConfig {
    /**
     * 发送地址
     */
    private String sendUrl;
    /**
     * 注册短信模版ID
     */
    private String registerTemplateId;
    private String appId;
    private String appKey;
    private String secretId;
    private String secretKey;
    private String sign;
}
