package com.mezjh.kcaforum.common.utils.config;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class PathConfig {

    private final String upUrl = "http://kca.mezjh.com";

    private final String downUrl = "http://localhost:11111";

    @ModelAttribute(name="http")
    public Object title() {
        return upUrl;
    }

}
