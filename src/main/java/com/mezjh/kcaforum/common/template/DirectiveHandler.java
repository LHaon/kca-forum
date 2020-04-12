package com.mezjh.kcaforum.common.template;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;

import java.util.Map;

/**
 * @author zjh
 * @date 2020/4/12
 */
public class DirectiveHandler {

    private Environment environment;
    private Map<String, TemplateModel> params;
    private TemplateModel[] loopVars;
    private TemplateDirectiveBody body;
    private Environment.Namespace namespace;

    /**
     * 构建 DirectiveHandler
     *
     * @param environment
     * @param params
     * @param loopVars
     * @param body
     */
    public DirectiveHandler(Environment environment, Map<String, TemplateModel> params, TemplateModel[] loopVars,
                            TemplateDirectiveBody body) {
        this.environment = environment;
        this.loopVars = loopVars;
        this.params = params;
        this.body = body;
        this.namespace = environment.getCurrentNamespace();
    }

}
