package com.mezjh.kcaforum.common.text.controller;

import com.mezjh.integrationkit.apiutils.ApiResult;
import com.mezjh.kcaforum.common.BaseController;
import com.mezjh.kcaforum.common.Views;
import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.common.text.service.TextService;
import com.mezjh.kcaforum.common.utils.IpUtils;
import com.mezjh.kcaforum.common.utils.MarkdownUtils;
import com.mezjh.kcaforum.common.utils.keywords.KeywordsUtils;
import com.mezjh.kcaforum.user.info.entity.AccountProfile;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/texts")
public class TextController extends BaseController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private TextService textService;
    @Autowired
    private KeywordsUtils keywordsUtils;

    @RequestMapping("/editing")
    public String toEdit(Long id, ModelMap model) {
        if (id != null && id > 0) {
            TextInfo view = textService.getTextInfoById(id);
            model.put("view", view);
        }
        return  view(Views.TEXT_EDIT);
    }

    @RequestMapping("/{id:\\d*}")
    public String view(@PathVariable Long id, ModelMap model, HttpServletRequest request) {
        TextInfo view = textService.getTextInfoById(id);
        Assert.notNull(view, "该文章已被删除");
        view.setContent(MarkdownUtils.renderMarkdown(view.getContent()));
        String ip = IpUtils.getIpAddr(request);
        view.setReadCount(textService.readCountAdd(view.getId(), ip, view.getReadCount()));
        model.put("view", view);
        return view(Views.TEXT_VIEW);
    }

    /**
     * 提交发布
     * @param text
     * @return
     */
    @PostMapping("/submit")
    public String submit(TextInfo text) {
        Assert.notNull(text, "参数不完整");
        Assert.state(StringUtils.isNotBlank(text.getTitle()), "标题不能为空");
        Assert.state(StringUtils.isNotBlank(text.getContent()), "内容不能为空");

        AccountProfile profile = getProfile();
        text.setUserId(profile.getId());

//        // 修改时, 验证归属
//        if (post.getId() > 0) {
//            PostVO exist = postService.get(post.getId());
//            Assert.notNull(exist, "文章不存在");
//            Assert.isTrue(exist.getAuthorId() == profile.getId(), "该文章不属于你");
//
//            postService.update(post);
//        } else {
//            postService.post(post);
//        }
        textService.subText(text);
        return String.format(Views.REDIRECT_USER_HOME, profile.getId());
    }

    @RequestMapping("/judgeText")
    @ResponseBody
    public ApiResult judgeText(String text) {

        String res = keywordsUtils.isKeywords(text);
        JSONObject jsonObject = new JSONObject(res);
        if (!jsonObject.get("conclusionType").equals("1")) {
            return ApiResult.fail("包含违规词汇,请检查后重新发布");
        }
        return ApiResult.success();
    }


    /**
     * 删除文章
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public ApiResult delete(@PathVariable Long id) {
        ApiResult data;
        try {
            textService.deleteText(id, getProfile().getId());
            data = ApiResult.success();
        } catch (Exception e) {
            data = ApiResult.fail(e.getMessage());
        }
        return data;
    }

}
