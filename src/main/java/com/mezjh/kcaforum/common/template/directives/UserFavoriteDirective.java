package com.mezjh.kcaforum.common.template.directives;

import com.mezjh.kcaforum.common.template.DirectiveHandler;
import com.mezjh.kcaforum.common.template.TemplateDirective;
import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.common.text.service.TextService;
import com.mezjh.kcaforum.user.info.entity.User;
import com.mezjh.kcaforum.user.info.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author zjh
 * @date 2020/5/20
 */
@Component
public class UserFavoriteDirective  extends TemplateDirective {
    @Autowired
    private TextService textService;
    @Autowired
    private UserInfoService userInfoService;

    @Override
    public String getName() {
        return "user_favorites";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {
        Long userId = handler.getInteger("userId", 0).longValue();
        User user = userInfoService.getUserById(userId);
        user.setLikeTextIds(user.getLikeTextIds().replaceAll("null,", ""));
        List<String> textIds = Arrays.asList(user.getLikeTextIds().split(","));
        List<TextInfo> likes = textService.getListByUserLikes(textIds);
        handler.put(RESULTS, likes).render();
    }
}
