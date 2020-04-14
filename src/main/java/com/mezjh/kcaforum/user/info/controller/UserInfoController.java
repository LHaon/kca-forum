package com.mezjh.kcaforum.user.info.controller;

import com.mezjh.integrationkit.apiutils.ApiResult;
import com.mezjh.kcaforum.common.BaseController;
import com.mezjh.kcaforum.common.Views;
import com.mezjh.kcaforum.common.utils.message.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zjh
 * @date 2020/4/14
 */
@Controller
@RequestMapping("/user")
public class UserInfoController extends BaseController {

    @Autowired
    private MessageUtil messageUtil;

    @GetMapping("/sendMessage")
    public ApiResult sendMesssage(String phone) {
        System.out.println(phone);
        try {
            messageUtil.send(phone);
        } catch (Exception e) {
            ApiResult.fail("e");
        }
        return ApiResult.success("短信发送成功");
    }

    @GetMapping("/register")
    public String toRegister() {
        return view(Views.REGISTER);
    }

    @GetMapping("/forget")
    public String toForget() {
        return view(Views.FORGET);
    }

}
