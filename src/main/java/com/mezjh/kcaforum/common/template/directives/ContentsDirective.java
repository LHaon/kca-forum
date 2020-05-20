package com.mezjh.kcaforum.common.template.directives;

import com.mezjh.integrationkit.apiutils.ApiResult;
import com.mezjh.kcaforum.common.index.service.IndexService;
import com.mezjh.kcaforum.common.template.DirectiveHandler;
import com.mezjh.kcaforum.common.template.TemplateDirective;
import com.mezjh.kcaforum.common.text.entity.TextInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 宏 contents
 *
 * @author zjh
 * @date 2020/4/12
 */
@Component
public class ContentsDirective extends TemplateDirective {

    @Autowired
    private IndexService indexService;
    @Override
    public String getName() {
        return "contents";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {
        List<TextInfo> datas = indexService.getIndexTextList();
        handler.put(RESULTS, ApiResult.success(datas)).render();
    }
}
