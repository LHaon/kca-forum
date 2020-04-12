package com.mezjh.kcaforum.common.template;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import org.springframework.util.Assert;

import java.io.IOException;
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

    public DirectiveHandler put(String key, Object value) throws TemplateModelException {
        namespace.put(key, wrap(value));
        return this;
    }

    /**
     * 包装对象
     *
     * @param object
     * @return
     * @throws TemplateModelException
     */
    public TemplateModel wrap(Object object) throws TemplateModelException {
        return environment.getObjectWrapper().wrap(object);
    }

    public void render() throws IOException, TemplateException {
        Assert.notNull(body, "must have template directive body");
        body.render(environment.getOut());
    }

    public Integer getInteger(String name, int defaultValue) throws Exception {
        Integer res = getInteger(name);
        return res == null ? defaultValue : res;
    }

    public Integer getInteger(String name) throws TemplateModelException {
        return TemplateModelUtils.converInteger(getModel(name));
    }

    private TemplateModel getModel(String name) {
        return params.get(name);
    }

}
