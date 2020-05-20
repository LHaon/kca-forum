package com.mezjh.kcaforum.common.template.directives;

import com.mezjh.kcaforum.common.comment.entity.CommentInfo;
import com.mezjh.kcaforum.common.comment.service.CommentService;
import com.mezjh.kcaforum.common.comment.vo.CommentVo;
import com.mezjh.kcaforum.common.template.DirectiveHandler;
import com.mezjh.kcaforum.common.template.TemplateDirective;
import com.mezjh.kcaforum.common.text.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zjh
 * @date 2020/5/20
 */
@Component
public class UserCommentsDirective extends TemplateDirective {
    @Autowired
    private CommentService commentService;
    @Autowired
    private TextService textService;

    @Override
    public String getName() {
        return "user_comments";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {
        Long userId = handler.getInteger("userId", 0).longValue();

        List<CommentVo> commentInfos = commentService.findAllByUserId(userId);
        for (CommentVo commentVo : commentInfos) {
            commentVo.setText(textService.getTextInfoById(commentVo.getTextId()));
        }
        handler.put(RESULTS, commentInfos).render();
    }
}
