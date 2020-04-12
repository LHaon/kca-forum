package com.mezjh.kcaforum.common.utils.config;

import com.mezjh.kcaforum.common.template.TemplateDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 自定义宏加载配置类
 *
 * @author zjh
 * @date 2020/4/12
 */
@Configuration
public class DirectiveConfigration {
    @Autowired
    private freemarker.template.Configuration configuration;
    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void setSharedVariable() {
        Map<String, TemplateDirective> map = applicationContext.getBeansOfType(TemplateDirective.class);
        map.forEach((k, v) -> configuration.setSharedVariable(v.getName(), v));
    }
}
