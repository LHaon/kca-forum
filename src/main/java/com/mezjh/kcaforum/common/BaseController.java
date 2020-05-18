package com.mezjh.kcaforum.common;

import com.mezjh.integrationkit.apiutils.ApiResult;
import com.mezjh.kcaforum.common.utils.MdFive;
import com.mezjh.kcaforum.common.utils.photo.PhotoFactory;
import com.mezjh.kcaforum.user.info.entity.AccountProfile;
import com.mezjh.kcaforum.user.info.entity.User;
import com.mezjh.kcaforum.user.info.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zjh
 * @date 2020/4/5
 */
@Slf4j
public class BaseController {

    @Autowired
    private SiteOptions siteOptions;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    protected PhotoFactory photoFactory;

    protected String view(String view) {
        return "/" + siteOptions.getValue("theme") + view;
    }

    protected ApiResult<AccountProfile> executeLogin(String username, String password, boolean rememberMe) {
        ApiResult<AccountProfile> ret = ApiResult.fail("登录失败");

        UsernamePasswordToken token = new UsernamePasswordToken(username, MdFive.md5(password), rememberMe);

        try {
            SecurityUtils.getSubject().login(token);
            ret = ApiResult.success(getProfile());
        } catch (Exception e) {
            ret = ApiResult.fail("用户名或密码不正确");
        } finally {
            return ret;
        }
    }

    protected ApiResult<AccountProfile> phoneJudge(String username, String password) {
        String redisCaptcha = "";
        redisCaptcha =  redisTemplate.opsForValue().get(username + "login");
        if (redisCaptcha.equals("") || !password.equals(redisCaptcha)) {
            return ApiResult.fail("验证码错误或验证码已过期");
        }

        User user = userInfoService.findUserByPhone(username);
        if (user == null) {
            ApiResult.fail("该手机号未注册");
        }

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword(),
            false);

        SecurityUtils.getSubject().login(token);
        return ApiResult.success(getProfile());
    }

    /**
     * 获取登录信息
     *
     * @return
     */
    protected AccountProfile getProfile() {
        Subject subject = SecurityUtils.getSubject();
        return (AccountProfile) subject.getPrincipal();
    }

    protected void putProfile(AccountProfile profile) {
        SecurityUtils.getSubject().getSession(true).setAttribute("profile", profile);
    }

    protected boolean isAuthenticated() {
        return SecurityUtils.getSubject() != null && (SecurityUtils.getSubject().isAuthenticated() || SecurityUtils.getSubject().isRemembered());
    }

    protected PageRequest wrapPageable(Sort sort) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        int pageNo = ServletRequestUtils.getIntParameter(request, "pageNo", 1);

        if (null == sort) {
            sort = Sort.unsorted();
        }
        return PageRequest.of(pageNo - 1, pageSize, sort);
    }
}
