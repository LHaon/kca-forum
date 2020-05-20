package com.mezjh.kcaforum.common.comment.controller;

import com.mezjh.integrationkit.apiutils.ApiResult;
import com.mezjh.kcaforum.common.BaseController;
import com.mezjh.kcaforum.common.comment.entity.CommentInfo;
import com.mezjh.kcaforum.common.comment.service.CommentService;
import com.mezjh.kcaforum.common.comment.vo.CommentVo;
import com.mezjh.kcaforum.common.utils.keywords.KeywordsUtils;
import com.mezjh.kcaforum.user.info.entity.AccountProfile;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zjh
 * @date 2020/5/16
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private KeywordsUtils keywordsUtils;


    @RequestMapping("/list/{toId}")
    public ApiResult<List<CommentVo>> view(@PathVariable Long toId) {
        return ApiResult.success(commentService.findAllByTextId(toId));
    }

    @RequestMapping("/submit")
    public ApiResult post(Long toId, String text, HttpServletRequest request) {
        if (!isAuthenticated()) {
            return ApiResult.fail("请先登录在进行操作");
        }

        long pid = ServletRequestUtils.getLongParameter(request, "pid", 0);

        if (toId <= 0 || StringUtils.isBlank(text)) {
            return ApiResult.fail("操作失败");
        }
        String res = keywordsUtils.isKeywords(text);
        JSONObject jsonObject = new JSONObject(res);
        Integer temp = (Integer) jsonObject.get("conclusionType");
        if (!temp.equals(1)) {
            return new ApiResult(false, "-1", "包含违禁词汇，请检查后重新发布");
        }

        AccountProfile profile = getProfile();

        CommentVo commentVo = new CommentVo();
        commentVo.setTextId(toId);
        commentVo.setContent(HtmlUtils.htmlEscape(text));
        commentVo.setUserId(profile.getId());
        commentVo.setPid(pid);

        commentService.subComment(commentVo);

//        if (!toId.equals(profile.getId())) {
//            sendMessage(profile.getId(), toId, pid);
//        }

        return new ApiResult(true, "200", "发表成功");
    }

    /**
     * 发送通知
     *
     * @param userId
     * @param postId
     */
//    private void sendMessage(long userId, long postId, long pid) {
//        MessageEvent event = new MessageEvent("MessageEvent");
//        event.setFromUserId(userId);
//
//        if (pid > 0) {
//            event.setEvent(Consts.MESSAGE_EVENT_COMMENT_REPLY);
//        } else {
//            event.setEvent(Consts.MESSAGE_EVENT_COMMENT);
//        }
//        // 此处不知道文章作者, 让通知事件系统补全
//        event.setPostId(postId);
//        applicationContext.publishEvent(event);
//    }
}
