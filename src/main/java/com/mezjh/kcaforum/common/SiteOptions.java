package com.mezjh.kcaforum.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjh
 * @date 2020/4/5
 */
@Configuration
@ConfigurationProperties(prefix = "site")
public class SiteOptions {

    /**
     * 系统版本号
     */
    private String version;

    /**
     * 运行文件存储路径
     */
    private String location;

    /**
     * 控制器配置
     */
    private Controls controls;

    /**
     * 属性配置
     */
    private Map<String, String> options = new HashMap<>();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Controls getControls() {
        return controls;
    }

    public void setControls(Controls controls) {
        this.controls = controls;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    public String getValue(String key) {
        return options.get(key);
    }

    public boolean hasValue(String key) {
        return StringUtils.isNotBlank(options.get(key));
    }

    public static class Controls {
        private boolean register;
        private boolean register_email_validate;
        private boolean post;
        private boolean comment;

        public boolean isRegister() {
            return register;
        }

        public void setRegister(boolean register) {
            this.register = register;
        }

        public boolean isRegister_email_validate() {
            return register_email_validate;
        }

        public void setRegister_email_validate(boolean register_email_validate) {
            this.register_email_validate = register_email_validate;
        }

        public boolean isPost() {
            return post;
        }

        public void setPost(boolean post) {
            this.post = post;
        }

        public boolean isComment() {
            return comment;
        }

        public void setComment(boolean comment) {
            this.comment = comment;
        }
    }

}

