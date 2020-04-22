package com.mezjh.kcaforum.common;

import com.mezjh.integrationkit.apiutils.ApiResult;
import com.mezjh.kcaforum.common.utils.MdFive;
import com.mezjh.kcaforum.user.info.entity.AccountProfile;
import com.mezjh.kcaforum.user.info.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zjh
 * @date 2020/4/5
 */
@Slf4j
public class BaseController {

    @Autowired
    private SiteOptions siteOptions;

    protected String view(String view) {
        return "/" + siteOptions.getValue("theme") + view;
    }

    protected ApiResult<AccountProfile> executeLogin(String username, String password, boolean rememberMe) {
        ApiResult<AccountProfile> ret = ApiResult.fail("登录失败");

        if (StringUtils.isAnyBlank(username, password)) {
            return ret;
        }

        UsernamePasswordToken token = new UsernamePasswordToken(username, MdFive.md5(password), rememberMe);

        try {
            SecurityUtils.getSubject().login(token);
            ret = ApiResult.success(getProfile());
        } catch (Exception e) {
            log.error(e.getMessage());
            ret = ApiResult.fail("用户名或密码不正确");
        } finally {
            return ret;
        }
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
}
