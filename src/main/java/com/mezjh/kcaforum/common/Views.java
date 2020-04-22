package com.mezjh.kcaforum.common;

/**
 * 页面管理接口
 *
 * @author zjh
 * @date 2020/4/4
 */
public interface Views {
    /**
     * 首页
     */
    String INDEX = "/index";

    String LOGIN = "/auth/login";

    String FORGET = "/auth/forget";

    String REGISTER = "/auth/register";

    String H_INDEX = "/channel/index";

    String TEXT_EDIT = "/channel/editing";

    String REDIRECT_USER_HOME = "redirect:/users/%d";

    String METHOD_TEXTS = "texts";

    String USER_METHOD_TEMPLATE = "/user/method_%s";
}
