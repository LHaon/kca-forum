package com.mezjh.kcaforum.common.template.directives;

import com.mezjh.kcaforum.common.template.DirectiveHandler;
import com.mezjh.kcaforum.common.template.TemplateDirective;
import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.common.text.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zjh
 * @date 2020/4/30
 */
@Component
public class UserContentsDirective extends TemplateDirective {
    @Autowired
    private TextService textService;

    @Override
    public String getName() {
        return "user_contents";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {
        Long userId = handler.getInteger("userId", 0).longValue();
        List<TextInfo> res = textService.getTextListByUserId(userId);
        handler.put(RESULTS, res).render();
    }
}
