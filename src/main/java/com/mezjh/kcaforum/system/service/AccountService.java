package com.mezjh.kcaforum.system.service;

import com.mezjh.kcaforum.system.dao.AccountMapper;
import com.mezjh.kcaforum.system.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zjh
 * @date 2019/11/11
 */
public interface AccountService {

    /**
     * 账号登陆
     *
     * @param username
     * @param password
     * @return
     */
    Account accountToLogin(String username, String password);

    /**
     * 通过用户名获取用户
     *
     * @param username
     * @return
     */
    Account getUserByUsername(String username);
}
