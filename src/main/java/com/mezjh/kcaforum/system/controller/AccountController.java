package com.mezjh.kcaforum.system.controller;

import com.mezjh.integrationkit.apiutils.ApiResult;
import com.mezjh.kcaforum.admin.info.service.AdminInfoService;
import com.mezjh.kcaforum.system.entity.Account;
import com.mezjh.kcaforum.system.service.AccountService;
import com.mezjh.kcaforum.user.info.entity.User;
import com.mezjh.kcaforum.user.info.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjh
 * @date 2019/11/11
 */
@RestController
@RequestMapping("/system")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AdminInfoService adminInfoService;
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public ApiResult<? extends Account> accountLogin(@RequestBody Account account) {
        Account temp = accountService.accountToLogin(account.getUsername(), account.getPassword());
        if (temp == null) {
            return ApiResult.error("用户名或密码错误");
        }
        if (temp.getAccountType() == 2) {
            return ApiResult.success(adminInfoService.getAdminInfoById(temp.getAccountId()));
        }
        return ApiResult.success(userInfoService.getUserInfoById(temp.getAccountId()));
    }

    @PostMapping("/register")
    public ApiResult<User> accountRegister(@RequestBody User user) {
        Account temp = accountService.getUserByUsername(user.getUsername());
        if (temp != null) {
            return ApiResult.error("用户名已存在");
        }
        if (userInfoService.userRegister(user) == 0) {
            return ApiResult.error("注册用户失败");
        }
        return ApiResult.success(userInfoService.getUserInfoById(
        accountService.getUserByUsername(user.getUsername()).getAccountId()));
    }
}
