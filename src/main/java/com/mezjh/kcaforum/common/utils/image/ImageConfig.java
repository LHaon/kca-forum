package com.mezjh.kcaforum.common.utils.image;

import com.UpYun;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zjh
 * @date 2020/3/24
 */
@Component
@ConfigurationProperties(
prefix = "image.config"
)
@Data
public class ImageConfig {
    /**
     * 服务名
     */
    private String serverName;
    /**
     * 域名
     */
    private String domain;
    /**
     * 操作员名称
     */
    private String username;
    /**
     * 操作员密码
     */
    private String password;
    /**
     * 文件路径
     */
    private String src;

    @Bean
    public UpYun getUpYun() {
        return new UpYun(this.serverName, this.username, this.password);
    }
}
