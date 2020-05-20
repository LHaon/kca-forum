package com.mezjh.kcaforum.user.info.controller;

import com.mezjh.kcaforum.common.BaseController;
import com.mezjh.kcaforum.common.Views;
import com.mezjh.kcaforum.user.info.entity.AccountProfile;
import com.mezjh.kcaforum.user.info.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zjh
 * @date 2020/4/22
 */
@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;
    /**
     * 用户文章
     * @param userId 用户ID
     * @param model  ModelMap
     * @return template name
     */
    @GetMapping(value = "/{userId}")
    public String posts(@PathVariable(value = "userId") Long userId,
                        ModelMap model, HttpServletRequest request) {
        return method(userId, Views.METHOD_TEXTS, model, request);
    }

    /**
     * 通用方法, 访问 users 目录下的页面
     * @param userId 用户ID
     * @param method 调用方法
     * @param model  ModelMap
     * @return template name
     */
    @GetMapping(value = "/{userId}/{method}")
    public String method(@PathVariable(value = "userId") Long userId,
                         @PathVariable(value = "method") String method,
                         ModelMap model, HttpServletRequest request) {
        System.out.println(method);
//        model.put("pageNo", ServletRequestUtils.getIntParameter(request, "pageNo", 1));

        // 访问消息页, 判断登录
//        if (Views.METHOD_MESSAGES.equals(method)) {
//            // 标记已读
//            AccountProfile profile = getProfile();
//            if (null == profile || profile.getId() != userId) {
//                throw new MtonsException("您没有权限访问该页面");
//            }
//            messageService.readed4Me(profile.getId());
//        }

        initUser(userId, model);
        return view(String.format(Views.USER_METHOD_TEMPLATE, method));
    }

    private void initUser(long userId, ModelMap model) {
        model.put("user", userInfoService.getUserById(userId));
        boolean owner = false;
        AccountProfile profile = getProfile();
        if (null != profile && profile.getId() == userId) {
            owner = true;
            putProfile(userInfoService.findProfile(profile.getId()));
        }
        model.put("owner", owner);
    }
}
