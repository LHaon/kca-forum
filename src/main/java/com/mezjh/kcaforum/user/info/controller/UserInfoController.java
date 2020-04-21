package com.mezjh.kcaforum.user.info.controller;

import com.mezjh.integrationkit.apiutils.ApiResult;
import com.mezjh.kcaforum.common.BaseController;
import com.mezjh.kcaforum.common.Views;
import com.mezjh.kcaforum.common.utils.message.MessageConfig;
import com.mezjh.kcaforum.common.utils.message.MessageUtil;
import com.mezjh.kcaforum.user.info.entity.User;
import com.mezjh.kcaforum.user.info.service.UserInfoService;
import com.mezjh.kcaforum.user.info.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @author zjh
 * @date 2020/4/14
 */
@Controller
@RequestMapping("/user")
public class UserInfoController extends BaseController {

    private final String REG = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private MessageUtil messageUtil;

    @GetMapping("/sendMessage")
    @ResponseBody
    public ApiResult sendMesssage(String phone, Integer msgType) {
        Pattern pattern = Pattern.compile(REG);
        if (!pattern.matcher(phone).matches() || phone == null) {
            return ApiResult.paramError("手机号格式不正确");
        }
        try {
            //messageUtil.send(phone, msgType);
        } catch (Exception e) {
            return ApiResult.fail("服务器错误，请稍后再试");
        }
        redisTemplate.opsForValue().set(phone+"register", "123456", 600, TimeUnit.SECONDS);
        return ApiResult.success("短信发送成功");
    }

    @PostMapping
    public ApiResult login(String username, String password) {
        return executeLogin(username, password, false);
    }

    @RequestMapping("/toRegister")
    @ResponseBody
    public ApiResult regisger(RegisterVo registerVo) {
        String code = redisTemplate.opsForValue().get(registerVo.getPhone()+"register");
        if (code == null || !code.equals(registerVo.getCode())) {
            return ApiResult.paramError("验证码错误或验证码已失效");
        }
        User user = userInfoService.findUserExist(registerVo);
        if (user != null) {
            if (user.getUsername() != null) {
                ApiResult.fail("该用户名已被占用");
            } else if(user.getPhone() != null) {
                ApiResult.fail("该手机号已被注册");
            }
        }
        int i = userInfoService.register(registerVo.toUser());
        System.out.println(i);
        //http://image-mezjh.test.upcdn.net/kca/15181091307/photo.jpeg
        return ApiResult.success("注册成功");
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
