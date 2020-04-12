package com.mezjh.kcaforum.common.template;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

/**
 * freemarker自定义宏
 *
 * @author zjh
 * @date 2020/4/12
 */
@Slf4j
public abstract class TemplateDirective implements TemplateDirectiveModel {

    protected static String RESULTS = "results";
    protected static String RESULT = "result";

    public abstract String getName();

    /**
     * 执行自定义宏
     * @param environment
     * @param map
     * @param templateModels
     * @param templateDirectiveBody
     * @throws TemplateException
     * @throws IOException
     */
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        try {
            execute(new DirectiveHandler(environment, map, templateModels, templateDirectiveBody));
        } catch (Exception e) {
            log.info("Custom macro execution exception msg={}", e);
        }
    }

    public abstract void execute(DirectiveHandler directiveHandler) throws Exception;
}
