package com.mezjh.kcaforum.common.template;

import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;
import freemarker.template.TemplateScalarModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 模板工具类
 *
 * @author zjh
 * @date 2020/4/12
 */
@Slf4j
public class TemplateModelUtils {

    /**
     * 将页面传来的参数变为整数
     *
     * @return
     */
    public static Integer converInteger(TemplateModel model) throws TemplateModelException {
        if (model != null) {
            if (model instanceof TemplateNumberModel) {
                return ((TemplateNumberModel) model).getAsNumber().intValue();
            } else if (model instanceof TemplateScalarModel) {
                String str = ((TemplateScalarModel) model).getAsString();
                if (StringUtils.isNotBlank(str)) {
                    try {
                        return Integer.parseInt(str);
                    } catch (Exception e) {
                        log.info("Illegal string={}", str);
                    }
                }
            }
        }
        return null;
    }
}
