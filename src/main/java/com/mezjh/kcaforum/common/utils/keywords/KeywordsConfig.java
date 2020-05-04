package com.mezjh.kcaforum.common.utils.keywords;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zjh
 * @date 2020/4/30
 */
@Component
@ConfigurationProperties(
prefix = "keywords.config"
)
@Data
public class KeywordsConfig {
    public String appId;
    public String apiKey;
    public String secretKey;
}
