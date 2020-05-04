package com.mezjh.kcaforum.user.info.controller;

import com.mezjh.integrationkit.apiutils.ApiResult;
import com.mezjh.kcaforum.common.BaseController;
import com.mezjh.kcaforum.common.Views;
import com.mezjh.kcaforum.common.utils.MdFive;
import com.mezjh.kcaforum.common.utils.message.MessageUtil;
import com.mezjh.kcaforum.user.Comm;
import com.mezjh.kcaforum.user.info.entity.AccountProfile;
import com.mezjh.kcaforum.user.info.entity.User;
import com.mezjh.kcaforum.user.info.service.UserInfoService;
import com.mezjh.kcaforum.user.info.vo.RegisterVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 * @author zjh
 * @date 2020/4/14
 */
@Controller
@RequestMapping("/user")
public class UserInfoController extends BaseController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private MessageUtil messageUtil;

    @GetMapping("/sendMessage")
    @ResponseBody
    public ApiResult sendMesssage(String phone, Integer msgType) {
        if (redisTemplate.opsForValue().get(phone + Integer.toString(msgType) + "flag") != null) {
            return ApiResult.fail("发送短信过于频繁");
        }
        if (msgType == 2) {
            User user = userInfoService.findUserByPhone(phone);
            if (user != null) {
                return ApiResult.fail("该手机号已被注册");
            }
        }
        Pattern pattern = Pattern.compile(Comm.PHONE_REG);
        if (!pattern.matcher(phone).matches() || phone == null) {
            return ApiResult.paramError("手机号格式不正确");
        }
        try {
            messageUtil.send(phone, msgType);
        } catch (Exception e) {
            return ApiResult.fail("服务器错误，请稍后再试");
        }
        return ApiResult.success("短信发送成功");
    }

    @PostMapping("/toRegister")
    @ResponseBody
    public ApiResult regisger(RegisterVo registerVo) {
        String code = redisTemplate.opsForValue().get(registerVo.getPhone()+"register");
        if (code == null || !code.equals(registerVo.getCode())) {
            return new ApiResult(true, "401", "验证码错误或验证码已失效");
        }
        User user = userInfoService.findUserExist(registerVo);
        if (user != null) {
            return new ApiResult(true, "401", "该用户名已被注册");
        }
        int i = userInfoService.register(registerVo.toUser());
        if (i < 1) {
            ApiResult.fail("服务器错误，注册失败");
        }
        ApiResult<AccountProfile> result = executeLogin(registerVo.getUsername(), registerVo.getPassword(), false);
        return ApiResult.success("注册成功");
    }

    @PostMapping(value = "/toLogin")
    public String login(String username, String password,
                        @RequestParam(value = "rememberMe",defaultValue = "0") Boolean rememberMe,
                        Integer loginType, ModelMap model) {
        String view = view(Views.LOGIN);

        ApiResult<AccountProfile> result = executeLogin(username, MdFive.md5(password), rememberMe);

        if (result.getCode().equals("200")) {
            view = String.format(Views.REDIRECT_USER_HOME, result.getData().getId());
        } else {
            model.put("message", result.getMessage());
        }
        return view;
    }

    @PostMapping(value = "/toLoginR")
    @ResponseBody
    public ApiResult<AccountProfile> login(String username, String password, Integer loginType) {
        if (loginType == 2) {
            return phoneJudge(username, password);
        }
        return executeLogin(username, password, false);
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response) {
        SecurityUtils.getSubject().logout();
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
        return Views.REDIRECT_INDEX;
    }

    @GetMapping("/login")
    public String toLogin() {
        return view(Views.LOGIN);
    }


    @GetMapping("/register")
    public String toRegister() {
        AccountProfile profile = getProfile();
        if (profile != null) {
            return String.format(Views.REDIRECT_USER_HOME, profile.getId());
        }
        return view(Views.REGISTER);
    }

    @GetMapping("/forget")
    public String toForget() {
        return view(Views.FORGET);
    }

    @GetMapping("/setting")
    public String toSetting() {
        return view(Views.SETTING);
    }

    @GetMapping("/setting/photo")
    public String toPhoto() {
        return view(Views.PHOTO_HEAD);
    }

    @GetMapping("/setting/password")
    public String toPassword() {
        return view(Views.PASSWORD);
    }

}
