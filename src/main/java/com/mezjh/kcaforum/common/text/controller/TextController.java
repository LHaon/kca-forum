package com.mezjh.kcaforum.common.text.controller;

import com.mezjh.kcaforum.common.BaseController;
import com.mezjh.kcaforum.common.Views;
import com.mezjh.kcaforum.common.text.entity.TextInfoVo;
import com.mezjh.kcaforum.common.text.service.TextService;
import com.mezjh.kcaforum.common.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/texts")
public class TextController extends BaseController {

    @Autowired
    private TextService textService;


    @RequestMapping("editing")
    public String toEdit() {
        return  view(Views.TEXT_EDIT);
    }

    @RequestMapping("/{id:\\d*}")
    public String view(@PathVariable Long id, ModelMap model) {
        TextInfoVo view = new TextInfoVo();
        view.setTitle("111");
        view.setContent("11111");

        Assert.notNull(view, "该文章已被删除");
        view.setContent(MarkdownUtils.renderMarkdown(view.getContent()));
        //postService.identityViews(id);
        model.put("view", view);
        return view(Views.TEXT_VIEW);
    }

}
